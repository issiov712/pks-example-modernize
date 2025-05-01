package pks.example.quick.infrastructure.rest;

import java.sql.Date;

public record PaymentDataObj (
	Date date,
	String amount,
	String interest,
	String principal
) { }
