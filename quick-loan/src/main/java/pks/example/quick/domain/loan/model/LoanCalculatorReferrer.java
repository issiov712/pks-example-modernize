package pks.example.quick.domain.loan.model;

public interface LoanCalculatorReferrer {
	public LoanAggregate calculateLoanSchedule(LoanAggregate loan);
}
