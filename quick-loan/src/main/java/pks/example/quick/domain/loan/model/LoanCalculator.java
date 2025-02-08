package pks.example.quick.domain.loan.model;

public interface LoanCalculator {
	public LoanAggregate calculateLoanSchedule(LoanAggregate loan);
}
