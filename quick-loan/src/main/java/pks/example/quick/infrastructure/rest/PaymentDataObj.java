package pks.example.quick.infrastructure.rest;

import java.sql.Date;

public record PaymentDataObj (
	Date date,
	MoneyDataObj amount,
	MoneyDataObj interest,
	MoneyDataObj principal
) { }
