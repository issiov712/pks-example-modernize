package pks.example.quick.domain.loan.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculateSimpleLevelLoan implements ScheduleCalculator {

	public static final long MILLIS_PER_DAY = 1000 * 60 * 60 * 24;

	static MonetaryAmountFormat fmt = MonetaryFormats.getAmountFormat(
		AmountFormatQueryBuilder.of(Locale.US)
			.set("pattern","#,##0.00").build());

	private static final Logger log = LoggerFactory.getLogger(CalculateSimpleLevelLoan.class);

	public List<LoanScheduleEntry> calculateLoanSchedule(LoanAggregate loan) {
		List<LoanCalculationEntry> schedule = new ArrayList<LoanCalculationEntry>();

		Date entryDate = loan.getFundsDisbursementDate();

		LoanCalculationEntry current = LoanCalculationEntry.builder()
			.loanPhase(LoanPhaseType.PHASE_A_FUNDS_DISBURSEMENT)
			.cumulativeDiscount(1)
			.periodDiscount(1)
			.principalBalance(loan.getAmount())
			.capitalizedBalance(Money.of(BigDecimal.ZERO, "USD"))
			.date(entryDate)
			.accruedInterest(Money.of(BigDecimal.ZERO, "USD"))
			.build();

		schedule.add(current);

		/*
		 * Loop through and calculate the days interest rate and the cumulative discount rate
		 * from the start of the principal payments.
		 */

		double curDiscount = 1.0; // current period present value discount for this period
		double mulDiscount = 1.0; // current period present value discount since loan disbursement
		double sumDiscount = 0.0; // running sum of discounts since loan disbursement

		log.trace(current.getDate().toString() + " " + current.getLoanPhase().getCode() + " " + current.getDate().toString() + " {} {} {}", 
			String.format("%9.5f",curDiscount), String.format("%9.5f",mulDiscount), String.format("%9.5f",sumDiscount));		

		do {

			LoanCalculationEntry previous = current;	// references to schedule entries
			Date currentDate = loan.getLoanPeriodType().nextIntervalDate(previous.getDate());
			
			switch (current.getLoanPhase()) {
				case PHASE_A_FUNDS_DISBURSEMENT :
				case PHASE_B_INITIAL_INTEREST_ACCRUAL :
					if (currentDate.compareTo(loan.getFirstStatementDate()) >= 0) {
						currentDate = loan.getFirstStatementDate();
					}

				case PHASE_C_CAPITALIZING_INTEREST :
					if (currentDate.compareTo(loan.getFirstInterestPaymentDate()) >= 0) {
						currentDate = loan.getFirstInterestPaymentDate();
					}

				case PHASE_D_INTEREST_ONLY_PAYMENTS :
					if (currentDate.compareTo(loan.getFirstPrincipalPaymentDate()) >= 0) {
						currentDate = loan.getFirstPrincipalPaymentDate();
					}
					
				case PHASE_E_INTEREST_AND_PRINCIPAL :
					if (currentDate.compareTo(loan.getCurrentMaturityDate()) >= 0) {
						currentDate = loan.getCurrentMaturityDate();

					}

				case PHASE_F_FINAL_PAYMENT_AT_MATURITY :
					if (currentDate.compareTo(loan.getFinalMaturityDate()) >= 0) {
						currentDate = loan.getFinalMaturityDate();

					}

				case PHASE_G_AMORTIZATION_CALCULATION_ONLY :
			}
			
			current = LoanCalculationEntry.builder()
				.date(currentDate)
				.loanPhase(LoanPhaseType.fromLoan(loan, currentDate))
				.build();
			
			// #TODO:  Align the date with the date in the loan definition and not just the next interval date
			// #TODO:  Need to handle situation where next interval date skips over a phase.  e.g. a week between phases for a monthly loan.

			switch (current.getLoanPhase()) {
				case PHASE_A_FUNDS_DISBURSEMENT :
					break;

				case PHASE_B_INITIAL_INTEREST_ACCRUAL :
				case PHASE_C_CAPITALIZING_INTEREST :
				case PHASE_D_INTEREST_ONLY_PAYMENTS :
					break;

				case PHASE_E_INTEREST_AND_PRINCIPAL :
				case PHASE_F_FINAL_PAYMENT_AT_MATURITY :
				case PHASE_G_AMORTIZATION_CALCULATION_ONLY :
					
					// #TODO:  Need to fix the calendar aspects of this date difference calculation.

					curDiscount = 1 / ( 1 + ((Math.round(current.getDate().getTime() / MILLIS_PER_DAY) - Math.round(previous.getDate().getTime() / MILLIS_PER_DAY)) * loan.getRate()) / 365 );
					mulDiscount = previous.getCumulativeDiscount() * curDiscount;
					sumDiscount += mulDiscount;
					break;
			}

			current.setPeriodDiscount(curDiscount);
			current.setCumulativeDiscount(mulDiscount);

			log.trace(previous.getDate().toString() + " " + current.getLoanPhase().getCode() + " " + current.getDate().toString() + " {} {} {}", 
				String.format("%9.5f",curDiscount), String.format("%9.5f",mulDiscount), String.format("%9.5f",sumDiscount));		

			schedule.add(current);
		
		} while (current.getDate().compareTo(loan.getFinalMaturityDate()) < 0);

		/*
		 * Loop through again, calculating the other values.
		 */

		// Money totalPrincipalPaid;
		// Money totalCapitalizedPaid;
		Money paymentDelta = Money.of(0,"USD");

		do {

			Money totalPrincipalPaid = Money.of(0,"USD");
			Money amortizationBalance = null;
			Money payment = Money.of(0,"USD");

			for (int i = 1; i < schedule.size(); i++) {

				Money principal = Money.of(0,"USD");
				Money capitalized = Money.of(0,"USD");
				Money balanceReduction = Money.of(0,"USD");
				LoanCalculationEntry previous = schedule.get(i-1);
				current = schedule.get(i);

				Money interest = previous.getPrincipalBalance()
					.add(previous.getCapitalizedBalance())
					.multiply((((Math.round(current.getDate().getTime() / MILLIS_PER_DAY) - Math.round(previous.getDate().getTime() / MILLIS_PER_DAY)) * loan.getRate()) / 365));
				current.setAccruedInterest(interest);

				switch (current.getLoanPhase()) {
					case PHASE_A_FUNDS_DISBURSEMENT :
					case PHASE_B_INITIAL_INTEREST_ACCRUAL :
					case PHASE_C_CAPITALIZING_INTEREST :
						capitalized = interest;
						break;

					case PHASE_D_INTEREST_ONLY_PAYMENTS :
						capitalized = Money.of(0,"USD");
						payment = interest;
						break;

					case PHASE_E_INTEREST_AND_PRINCIPAL :					
						if (amortizationBalance == null) {
							amortizationBalance = previous.getPrincipalBalance().add(previous.getCapitalizedBalance());
						}
						payment = amortizationBalance.divide(sumDiscount).add(paymentDelta);
						balanceReduction = payment.add(interest.negate());
						if (balanceReduction.compareTo(previous.getCapitalizedBalance()) <= 0) {
							capitalized = balanceReduction.negate();
							balanceReduction = Money.of(0,"USD");
						} else {
							capitalized = previous.getCapitalizedBalance().negate();
							balanceReduction = balanceReduction.add(capitalized);
						}
						principal = balanceReduction;
						break;

					case PHASE_F_FINAL_PAYMENT_AT_MATURITY :
						capitalized = previous.getCapitalizedBalance().negate();
						principal = loan.getAmount().add(totalPrincipalPaid.negate());
						payment = interest.add(previous.getCapitalizedBalance()).add(principal);

						schedule = schedule.subList(0,i);
						break;
				
					case PHASE_G_AMORTIZATION_CALCULATION_ONLY :
						break;
				}

				totalPrincipalPaid = totalPrincipalPaid.add(principal);

				current.setPaymentAmount(payment);
				current.setAccruedInterest(interest);
				current.setPrincipalPayment(principal);
				current.setPrincipalBalance(previous.getPrincipalBalance().add(principal.negate()));
				current.setCapitalizedBalance(previous.getCapitalizedBalance().add(capitalized));

				log.trace(previous.getDate().toString() + " " + current.getLoanPhase().getCode() + " " + current.getDate().toString() + " "
					+ String.format("%9.5f",current.getPeriodDiscount()) + " " + String.format("%9.5f",current.getCumulativeDiscount()) + " " + String.format("%9.5f",0.0) + " "
					+ String.format("%10s",fmt.format(interest)) + " " + String.format("%10s",fmt.format(principal)) + " " + String.format("%10s",fmt.format(payment)) + " "
					+ String.format("%10s",fmt.format(current.getPrincipalBalance())) + " " + String.format("%10s",fmt.format(current.getCapitalizedBalance())));

				}


			if (log.isDebugEnabled()) {
				String csv = 
					"loan calculation dump in csv format\n" +
					"name: " + loan.getName() + "\n" +
					"description: " + loan.getDescription() + "\n" +
					"amount: " + loan.getAmount() + "\n" +
					"disbursement date: " + loan.getFundsDisbursementDate() + "\n" +
					"first statement date: " + loan.getFirstStatementDate() + "\n" +
					"first interest payment date: " + loan.getFirstInterestPaymentDate() + "\n" +
					"first balance payment date: " + loan.getFirstPrincipalPaymentDate() + "\n" +
					"current maturity date: " + loan.getCurrentMaturityDate() + "\n" +
					"amortization maturity date: " + loan.getFinalMaturityDate() + "\n" +
					"\"previous date\",\"loan-phase\",\"current date\",\"pv-cur-discount\",\"pv-mul-discount\",\"interest\",\"principal\",\"payment\",\"balance\",\"capitalized\"\n";
				for (int i = 1; i < schedule.size(); i++) {
					LoanCalculationEntry previous = schedule.get(i-1);
					current = schedule.get(i);
					csv = csv + "\"" + previous.getDate().toString() + "\",\"" + current.getLoanPhase().getCode() + "\",\"" + current.getDate().toString() + "\",\""
						+ String.format("%9.5f",current.getPeriodDiscount()) + "\",\""
						+ String.format("%9.5f",current.getCumulativeDiscount()) + "\",\""
						+ String.format("%10s",fmt.format(current.getAccruedInterest())) + "\",\""
						+ String.format("%10s",fmt.format(current.getPrincipalPayment())) + "\",\""
						+ String.format("%10s",fmt.format(current.getPaymentAmount())) + "\",\""
						+ String.format("%10s",fmt.format(current.getPrincipalBalance())) + "\",\"" 
						+ String.format("%10s",fmt.format(current.getCapitalizedBalance())) + "\"\n";
				}
				log.debug(csv);
			}

		} while (false); // finalBalance.compareTo(loan.getAmount()) != 0);

		/*
		 * Now use MapStruct to create a list of LoanScheduleEntries from the
		 * list of LoanCalculationEntries.
		 */
		
		return CalculationEntryMapper.INSTANCE.mapToLoanScheduleEntryList(schedule);
	}

}
