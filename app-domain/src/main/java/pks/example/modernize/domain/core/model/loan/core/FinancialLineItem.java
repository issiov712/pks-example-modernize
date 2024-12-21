package pks.example.modernize.domain.core.model.loan.core;

import java.sql.Date;

import org.javamoney.moneta.Money;

import lombok.Getter;

@Getter
public class FinancialLineItem {
    Date scheduledDate;
    Date effectiveDate;
    Money totalNetAmount;
}
