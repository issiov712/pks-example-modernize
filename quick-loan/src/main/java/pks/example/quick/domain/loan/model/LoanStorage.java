package pks.example.quick.domain.loan.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.javamoney.moneta.Money;

public class LoanStorage {

	static final Map<UUID,LoanAggregate> loans = new HashMap<UUID,LoanAggregate>();

	static void save(LoanAggregate loan) {
		loans.put(loan.getId(), loan);
	}

	List<LoanAggregate> list() {
		return new ArrayList<LoanAggregate>(loans.values());
	}

	LoanAggregate find(UUID loanId) {
		return loans.get(loanId);
	}

	

	static {

		save(LoanAggregate.builder()
				.id(UUID.randomUUID())
				.name("example loan")
				.description("a first loan")
				.amount(Money.of(37500,"USD"))
				.fundsDisbursementDate(Date.valueOf("2023-11-21"))
				.firstInterestPaymentDate(Date.valueOf("2023-12-12"))
				.firstPrincipalPaymentDate(Date.valueOf("2024-12-12"))
				.currentMaturityDate(Date.valueOf("2029-07-12"))
				.finalMaturityDate(Date.valueOf("2033-07-12"))
				.build()
				.priceLoan());

		save(LoanAggregate.builder()
				.id(UUID.randomUUID())
				.name("example loan # 2")
				.description("a second loan to check")
				.amount(Money.of(15000,"USD"))
				.fundsDisbursementDate(Date.valueOf("2021-01-15"))
				.firstInterestPaymentDate(Date.valueOf("2021-02-19"))
				.firstPrincipalPaymentDate(Date.valueOf("2021-02-19"))
				.currentMaturityDate(Date.valueOf("2027-07-19"))
				.finalMaturityDate(Date.valueOf("2027-07-19"))
				.build()
				.priceLoan());
	}
}
