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

	private static final Logger log = LoggerFactory.getLogger(CalculateSimpleLevelLoan.class);

	public List<LoanScheduleEntry> calculateLoanSchedule(LoanAggregate loan) {
		List<LoanCalculationEntry> schedule = new ArrayList<LoanCalculationEntry>();

		Date entryDate = loan.getFundsDisbursementDate();

		LoanCalculationEntry current = LoanCalculationEntry.builder()
			.loanPhase(LoanPhaseType.PHASE_A_FUNDS_DISBURSEMENT)
			.cumulativeDiscount(1)
			.periodDiscount(1)
			.principalBalance(loan.getAmount())
			.capitalziedBalance(Money.of(BigDecimal.ZERO, "USD"))
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

		MonetaryAmountFormat fmt = MonetaryFormats.getAmountFormat(
			AmountFormatQueryBuilder.of(Locale.US)
				.set("pattern","#,##0.00").build());
		Money paymentDelta = Money.of(0,"USD");
		Money totalPrincipalPaid;

		do {

			totalPrincipalPaid = Money.of(0,"USD");
			Money payment = loan.getAmount().divide(sumDiscount).add(paymentDelta);

			for (int i = 1; i < schedule.size(); i++) {

				Money interest  = Money.of(0,"USD");
				Money principal = Money.of(0,"USD");
				LoanCalculationEntry previous = schedule.get(i-1);
				current = schedule.get(i);

				switch (current.getLoanPhase()) {
					case PHASE_A_FUNDS_DISBURSEMENT :
					case PHASE_B_INITIAL_INTEREST_ACCRUAL :
					case PHASE_C_CAPITALIZING_INTEREST :
					case PHASE_D_INTEREST_ONLY_PAYMENTS :
						break;

					case PHASE_E_INTEREST_AND_PRINCIPAL :
						interest = previous.getPrincipalBalance().multiply((((Math.round(current.getDate().getTime() / MILLIS_PER_DAY) - Math.round(previous.getDate().getTime() / MILLIS_PER_DAY)) * loan.getRate()) / 365));
						principal = payment.add(interest.negate());
						current.setPaymentAmount(payment);
						current.setAccruedInterest(interest);
						current.setPrincipalPayment(principal);
						totalPrincipalPaid = totalPrincipalPaid.add(principal);
						current.setPrincipalBalance(previous.getPrincipalBalance().add(principal.negate()));
						current.setCapitalziedBalance(previous.getCapitalziedBalance());
						break;

					case PHASE_F_FINAL_PAYMENT_AT_MATURITY :
						interest = previous.getPrincipalBalance().multiply((((Math.round(current.getDate().getTime() / MILLIS_PER_DAY) - Math.round(previous.getDate().getTime() / MILLIS_PER_DAY)) * loan.getRate()) / 365));
						principal = loan.getAmount().add(totalPrincipalPaid.negate());
						current.setPaymentAmount(principal.add(interest));
						current.setAccruedInterest(interest);
						current.setPrincipalPayment(principal);
						totalPrincipalPaid = totalPrincipalPaid.add(principal);
						current.setPrincipalBalance(previous.getPrincipalBalance().add(principal.negate()));
						current.setCapitalziedBalance(previous.getCapitalziedBalance());
						break;
				
					case PHASE_G_AMORTIZATION_CALCULATION_ONLY :
						break;
				}

				log.trace(previous.getDate().toString() + " " + current.getLoanPhase().getCode() + " " + current.getDate().toString() + " "
					+ String.format("%9.5f",current.periodDiscount) + " " + String.format("%9.5f",current.cumulativeDiscount) + " " + String.format("%9.5f",0.0) + " "
					+ fmt.format(interest) + " " + fmt.format(principal) + " " + fmt.format(payment) + " "
					+ fmt.format(current.getPrincipalBalance()) + " " + fmt.format(current.getCapitalziedBalance()));
			}

		} while (false); // finalBalance.compareTo(loan.getAmount()) != 0);

		/*
		 * Now use MapStruct to create a list of LoanScheduleEntries from the
		 * list of LoanCalculationEntries.
		 */

		
		return CalculationEntryMapper.INSTANCE.mapToLoanScheduleEntryList(schedule);
	}

}
