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
			.loanPeriodType(LoanPeriodType.QUARTERLY)
			.loanType(LoanMethodType.SIMPLE_LEVEL_PAYMENT)
			.rate(0.04325)
			.amount(Money.of(12500,"USD"))
			.fundsDisbursementDate(    Date.valueOf("2023-11-15"))
			.firstStatementDate(       Date.valueOf("2024-02-15"))
			.firstInterestPaymentDate( Date.valueOf("2024-02-15"))
			.firstPrincipalPaymentDate(Date.valueOf("2024-02-15"))
			.currentMaturityDate(      Date.valueOf("2029-02-15"))
			.finalMaturityDate(        Date.valueOf("2029-02-15"))
			.build()
			.calculateLoanSchedule());

		save(LoanAggregate.builder()
			.id(UUID.randomUUID())
			.name("example monthly loan")
			.description("a second monthly loan")
			.loanPeriodType(LoanPeriodType.MONTHLY)
			.loanType(LoanMethodType.SIMPLE_LEVEL_PAYMENT)
			.rate(0.04325)
			.amount(Money.of(12500,"USD"))
			.fundsDisbursementDate(    Date.valueOf("2023-11-15"))
			.firstStatementDate(       Date.valueOf("2024-02-15"))
			.firstInterestPaymentDate( Date.valueOf("2024-02-15"))
			.firstPrincipalPaymentDate(Date.valueOf("2025-02-15"))
			.currentMaturityDate(      Date.valueOf("2029-02-15"))
			.finalMaturityDate(        Date.valueOf("2029-02-15"))
			.build()
			.calculateLoanSchedule());

		save(LoanAggregate.builder()
			.id(UUID.randomUUID())
			.name("complex loan")
			.description("a very complex loan")
			.loanPeriodType(LoanPeriodType.MONTHLY)
			.loanType(LoanMethodType.SIMPLE_LEVEL_PAYMENT)
			.rate(0.03825)
			.amount(Money.of(150000,"USD"))
			.fundsDisbursementDate(    Date.valueOf("2022-08-05"))	// loan starts
			.firstStatementDate(       Date.valueOf("2022-09-22"))  // first statement delayed
			.firstInterestPaymentDate( Date.valueOf("2023-02-11"))  // change of statement date, start interest
			.firstPrincipalPaymentDate(Date.valueOf("2023-05-17"))  // change of statement date, start principal
			.currentMaturityDate(      Date.valueOf("2025-04-01"))  // change of statement date, final payment
			.finalMaturityDate(        Date.valueOf("2027-02-15"))  // amortization target date, force lump final payment
			.build()
			.calculateLoanSchedule());
	}
}
