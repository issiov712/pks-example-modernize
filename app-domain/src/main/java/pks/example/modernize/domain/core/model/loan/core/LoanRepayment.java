package pks.example.modernize.domain.core.model.loan.core;

import org.javamoney.moneta.Money;

public class LoanRepayment extends FinancialLineItem {
    Money interestAccrued;
    Money capitalizedInterestAccrued;

    Money interestPayed;
    Money capitalizedInterestPayed;
    Money principalAmountPayed;

    Money capitalizedInterestBalance;
    Money principalBalance;
}
