package pks.example.modernize.domain.loan.model;

import java.util.Optional;

import org.javamoney.moneta.Money;

public class PriceSimpleLoan implements PricingStrategy {

	public Boolean canUse(final LendingCommitment commitment, final LoanTermSheet loan) {
		return Boolean.TRUE;
	}

	public Optional<LoanContract> priceLoan(final LendingCommitment commitment, final LoanTermSheet loan) {
		LoanContract contract = new LoanContract();
		return Optional.of(contract);
	}

	public Money valueLoan(final LoanContract loan) {
		Money value = Money.of(0,"USD");
		return value;
	}
}
