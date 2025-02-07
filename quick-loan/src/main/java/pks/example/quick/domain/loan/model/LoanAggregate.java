package pks.example.quick.domain.loan.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.javamoney.moneta.Money;

import lombok.Builder;
import lombok.Value;

@Value @Builder
public class LoanAggregate {
	private UUID id;
	private String name;
	private String description;
	private Money amount;
	private double rate;
	private Date fundsDisbursementDate;
	private Date firstInterestPaymentDate;
	private Date firstPrincipalPaymentDate;
	private Date currentMaturityDate;
	private Date finalMaturityDate;
	@Builder.Default private LoanMethodType loanType = LoanMethodType.SIMPLE_LEVEL_PAYMENT;
	@Builder.Default private LoanPeriodType loanPeriodType = LoanPeriodType.MONTHLY;

	private List<LoanPayment> payments = new ArrayList<LoanPayment>();

	// #TODO: Really need to create your own constructor to set defaults between properties and hide the payment list


	public LoanPayment[] getPayments() {
		return payments.toArray(new LoanPayment[0]);
	}

	public LoanAggregate priceLoan() {
		payments.add(LoanPayment.builder()
						.date(this.currentMaturityDate)
						.amount(Money.of(100,"USD"))
						.interest(Money.of(100,"USD"))
						.principal(Money.of(100,"USD"))
						.build());
		return this;
	}

}
