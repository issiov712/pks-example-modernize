package pks.example.modernize.domain.loan.model;

import java.util.Optional;

import org.javamoney.moneta.Money;

public interface PricingStrategy {
	public Boolean canUse(final LendingCommitment commitment, final LoanTermSheet loan);
	public Optional<LoanContract> priceLoan(final LendingCommitment commitment, final LoanTermSheet loan);
	public Money valueLoan(final LoanContract loan);
}
