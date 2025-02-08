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
	private Date firstStatementDate;
	private Date firstInterestPaymentDate;
	private Date firstPrincipalPaymentDate;
	private Date currentMaturityDate;
	private Date finalMaturityDate;
	@Builder.Default private LoanMethodType loanType = LoanMethodType.SIMPLE_LEVEL_PAYMENT;
	@Builder.Default private LoanPeriodType loanPeriodType = LoanPeriodType.MONTHLY;

	private List<LoanScheduleEntry> payments = new ArrayList<LoanScheduleEntry>();

	// #TODO: Really need to create your own constructor to set defaults between properties and hide the payment list


	public LoanScheduleEntry[] getLoanSchedule() {
		return payments.toArray(new LoanScheduleEntry[0]);
	}

	public LoanAggregate calculateLoanSchedule() {
		if (loanType != null) {
			return loanType.calculateLoanSchedule(this);
		}
		
		return this;
	}

}
