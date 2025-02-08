package pks.example.quick.domain.loan.model;

import java.sql.Date;

import org.javamoney.moneta.Money;

import lombok.Builder;
import lombok.Value;


@Value @Builder
public class LoanCalculationEntry {
	LoanPhaseType loanPhase;
	Date date;
	double periodDiscount;
	double cumulativeDiscount;
	Money paymentAcount;
	Money accruedInterest;
	Money originalPrincipalBalance;
	Money capitalziedInterestBalance;
}
