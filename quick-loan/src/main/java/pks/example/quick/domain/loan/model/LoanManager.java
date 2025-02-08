package pks.example.quick.domain.loan.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class LoanManager {
	@Getter @Setter private static Double interestRate = 0.0450;

	private static final LoanStorage storage = new LoanStorage();

	public static List<LoanAggregate> getAllLoans() {
		return storage.list();
	}

	public static LoanAggregate getLoan(UUID id) {
		return storage.find(id);
	}

	public static LoanAggregate calculateLoanSchedule(UUID id) {
		LoanAggregate loan = storage.find(id);
		return loan.calculateLoanSchedule();
	}


	public void createLoan() { }

}
