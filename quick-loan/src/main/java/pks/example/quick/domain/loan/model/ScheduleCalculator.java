package pks.example.quick.domain.loan.model;

import java.util.List;

public interface ScheduleCalculator {
	public List<LoanScheduleEntry> calculateLoanSchedule(LoanAggregate loan);
}
