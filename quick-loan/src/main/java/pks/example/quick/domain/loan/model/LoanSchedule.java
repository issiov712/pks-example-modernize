package pks.example.quick.domain.loan.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value @Builder
public class LoanSchedule {
	private List<LoanPayment> payments = new ArrayList<LoanPayment>();

	public void append(LoanPayment payment) {
		this.payments.add(payment);
	}

	public LoanPayment[] getSchedule() {
		return payments.toArray(new LoanPayment[0]);
	}
}
