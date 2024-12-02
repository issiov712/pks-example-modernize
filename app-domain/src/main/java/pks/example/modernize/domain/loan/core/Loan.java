package pks.example.modernize.domain.loan.core;

import java.sql.Date;

import org.javamoney.moneta.Money;

public class Loan {
    private Date startDate;
    private Double interestRate;
    private Money principalAmount;
    private Date payoffDate;
    private FinancialSchedule schedule;

    private Loan() {
        schedule = new FinancialSchedule();
    }

    public static Loan createSimpleLoan(Date startDate, Double interestRate, Money principalAmount, Date payoffDate) {
        Loan loan = new Loan();

        return loan;
    }



    public static LoanBuilder builder() {
        return new LoanBuilder();
    }

    public static class LoanBuilder {

        public LoanBuilder() {

        }

        public LoanBuilder startDate(Date startDate) {
            return this;
        }

        public LoanBuilder interestRate(Double interestRate) {
            return this;
        }

        public LoanBuilder principalAmount(Money principalAmount) {
            return this;
        }

        public LoanBuilder financialSchedule(FinancialSchedule schedule) {
            return this;
        }
        
        public Loan build() {
            return new Loan();
        }
    }
}
