package pks.example.modernize.domain.loan.model.factory;

import pks.example.modernize.domain.loan.model.LoanType;

public class LoanFactory {
	public static LoanBuilder builder() { return new SimpleLoanBuilder(); }
	public static LoanBuilder builder(LoanType loanType) { return new SimpleLoanBuilder(); }
}
