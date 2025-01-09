package pks.example.modernize.domain.loan.model;

/**
 * <p>A {@link Contract} is a generic that follows the lifecycle of negotiating
 * and ratifying a financial contract until its final close out.</p>
 * 
 * <p>The {@link TermSheet} is the contents of the contract.
 */
public interface Contract<T extends TermSheet> {

}
