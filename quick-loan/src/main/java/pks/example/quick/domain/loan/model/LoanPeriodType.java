package pks.example.quick.domain.loan.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public enum LoanPeriodType implements LoanPeriod {

	MONTHLY {
		public Date nextIntervalDate(Date fromThisDate) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(fromThisDate.getTime());
			calendar.add(Calendar.MONTH, 1);
			return new Date(calendar.getTimeInMillis());
		}

		public String getName() { return "Monthly"; }

		public String getDescription() { return "A monthly payment schedule."; }
	},

	QUARTERLY {
		public Date nextIntervalDate(Date fromThisDate) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(fromThisDate.getTime());
			calendar.add(Calendar.MONTH, 3);
			return new Date(calendar.getTimeInMillis());
		}

		public String getName() { return "Quarterly"; }

		public String getDescription() { return "A quarterly payment schedule."; }
	};

	public static List<LoanPeriod> getPeriodTypes() {
		return Arrays.asList(
			LoanPeriodType.MONTHLY,
			LoanPeriodType.QUARTERLY
		);
	}
}
