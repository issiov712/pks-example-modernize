package pks.example.quick.domain.loan.model;

import java.util.List;

public class LoanManager {

	private static final LoanStorage storage = new LoanStorage();

	public static  List<LoanAggregate> getAllLoans() {
		return storage.list();
	}

	public void createLoan() { }

}
