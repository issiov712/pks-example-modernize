package pks.example.modernize.domain.loan.core;

import java.sql.Date;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class LoanTest {
    

    @Test
    void SimpleLoadTest() {
        Loan loan = Loan.builder()
                        .startDate(Date.valueOf("2024-12-02"))
                        .interestRate(Double.valueOf(0.065d))
                        .build(); // , Money.of(15000,"USD"), Date.valueOf("2032-12-02"));
    }
}
