package pks.example.quick.domain.loan.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.javamoney.moneta.Money;

public class CalculateSimpleLevelLoan implements LoanCalculator {

	public LoanAggregate calculateLoanSchedule(LoanAggregate loan) {
		List<LoanCalculationEntry> schedule = new ArrayList<LoanCalculationEntry>();

		Date entryDate = loan.getFundsDisbursementDate();

		LoanCalculationEntry first = LoanCalculationEntry.builder()
										.loanPhase(LoanPhaseType.PHASE_A_FUNDS_DISBURSEMENT)
										.cumulativeDiscount(0)
										.periodDiscount(0)
										.originalPrincipalBalance(loan.getAmount())
										.capitalziedInterestBalance(Money.of(BigDecimal.ZERO, "USD"))
										.date(entryDate)
										.accruedInterest(Money.of(BigDecimal.ZERO, "USD"))
										.build();
		schedule.add(first);

		/*
		 * Loop through and calculate the days interest rate and the cumulative discount rate
		 * from the start of the principal payments.
		 */

		while (entryDate.before(loan.getCurrentMaturityDate())) {

			entryDate = loan.getLoanPeriodType().nextIntervalDate(entryDate);
			LoanPhaseType loanPhase = LoanPhaseType.fromLoan(loan, entryDate);

			switch (loanPhase) {
				PHASE_B_INITIAL_INTEREST_ACCRUAL :

					break;

				PHASE_C_CAPITALIZING_INTEREST :
					break;

				PHASE_D_INTEREST_ONLY_PAYMENTS :
					break;

				PHASE_D_INTEREST_ONLY_PAYMENTS :
					break;

				PHASE_E_INTEREST_AND_PRINCIPAL :
					break;

				PHASE_F_FINAL_PAYMENT_AT_MATURITY :
					break;
			}

		}

		/*
		 * Loop through again, calculating the other values.
		 */

		 
		/*
		 * Now use MapStruct to create a list of LoanScheduleEntries from the
		 * list of LoanCalculationEntries.
		 */

		return loan;		
	}

}
