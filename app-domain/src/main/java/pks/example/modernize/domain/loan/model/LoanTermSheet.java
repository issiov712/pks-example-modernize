package pks.example.modernize.domain.loan.model;

import java.math.BigDecimal;
import java.sql.Date;

public class LoanTermSheet implements TermSheet {
	String purpose;
	Double rate;
	BigDecimal amount;
	Date disbursemenDate;
	Date finalDate;
	TimeLinePace periodicity;
}
