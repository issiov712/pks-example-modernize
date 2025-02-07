package pks.example.quick.domain.loan.model;

import java.sql.Date;

public interface LoanPeriod {
	Date nextIntervalDate(Date fromThisDate);
	String getName();
	String getDescription();
}
