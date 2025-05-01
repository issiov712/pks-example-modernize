package pks.example.quick.domain.loan.port;

import java.util.List;
import java.util.UUID;

import pks.example.quick.domain.loan.model.LoanAggregate;

public interface LoanPort {
	LoanAggregate getLoan(UUID pkid);
	void newLoan(LoanAggregate loan);
	List<LoanAggregate> getAllLoans();
}
