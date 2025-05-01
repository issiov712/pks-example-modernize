package pks.example.quick.domain.loan.model;

import java.sql.Date;

import org.javamoney.moneta.Money;

import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Data @Builder
public class LoanCalculationEntry {
	LoanPhaseType loanPhase;
	Date date;
	double periodDiscount;
	double cumulativeDiscount;
	Money paymentAmount;
	Money accruedInterest;
	Money principalPayment;
	Money principalBalance;
	Money capitalizedBalance;
}
