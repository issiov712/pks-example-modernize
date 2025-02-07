package pks.example.quick.domain.loan.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public enum LoanPeriodType implements LoanPeriod {

	MONTHLY(
		"M",
		"Monthly",
		"A monthly payment schedule."
	) {
		public Date nextIntervalDate(Date fromThisDate) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(fromThisDate.getTime());
			calendar.add(Calendar.MONTH, 1);
			return new Date(calendar.getTimeInMillis());
		}
	},

	QUARTERLY(
		"Q",
		"Quarterly",
		"A quarterly payment schedule."
	) {
		public Date nextIntervalDate(Date fromThisDate) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(fromThisDate.getTime());
			calendar.add(Calendar.MONTH, 3);
			return new Date(calendar.getTimeInMillis());
		}
	};

	public static List<LoanPeriod> getPeriodTypes() {
		return Arrays.asList(
			LoanPeriodType.MONTHLY,
			LoanPeriodType.QUARTERLY
		);
	}

	private final String _code;
	private final String _name;
	private final String _description;

	private LoanPeriodType(final String code, final String name, final String description) {
		this._code = code;
		this._name = name;
		this._description = description;
	}

	public String getCode() { return this._code; }
	public String getName() { return this._name; }
	public String getDescription() { return this._description; }

	public String toString() { return "LoanPeriodType('" + this._code +"')'"; }
}
