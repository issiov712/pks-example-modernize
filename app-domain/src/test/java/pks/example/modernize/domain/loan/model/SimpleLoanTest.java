package pks.example.modernize.domain.loan.model;

import java.sql.Date;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import pks.example.modernize.domain.loan.model.factory.LoanBuilder;
import pks.example.modernize.domain.loan.model.factory.LoanFactory;


public class SimpleLoanTest {

    @Test
    void SimpleLoanTest() {
		Loan loan = LoanFactory.builder()
			;

	}
}
