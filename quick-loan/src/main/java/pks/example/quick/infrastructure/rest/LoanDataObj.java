package pks.example.quick.infrastructure.rest;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.javamoney.moneta.Money;

public record LoanDataObj (
	UUID id,
	String name,
	String description,
	double rate,
	String amount,
	Date fundsDisbursementDate,
	Date firstStatementDate,
	Date firstInterestPaymentDate,
	Date firstPrincipalPaymentDate,
	Date currentMaturityDate,
	Date finalMaturityDate,
	String loanMethodType,
	String loanPeriodType,
	List<PaymentDataObj> payments
	) { }
