package pks.example.quick.domain.loan.model;

import java.sql.Date;

import org.javamoney.moneta.Money;

import lombok.Builder;
import lombok.Value;

@Value @Builder
public class LoanScheduleEntry {
	private Date date;
	private Money amount;
	private Money principal;
	private Money interest;
}
