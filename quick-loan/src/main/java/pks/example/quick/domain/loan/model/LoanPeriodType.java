package pks.example.quick.domain.loan.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

	private final String ENUM_CODE;
	private final String ENUM_NAME;
	private final String ENUM_DESC;

	private LoanPeriodType(final String code, final String name, final String description) {
		this.ENUM_CODE = code;
		this.ENUM_NAME = name;
		this.ENUM_DESC = description;
	}

	public String getCode() { return this.ENUM_CODE; }
	public String getName() { return this.ENUM_NAME; }
	public String getDescription() { return this.ENUM_DESC; }

	public String toString() { return "LoanPeriodType('" + this.ENUM_CODE +"')'"; }

	private static final Map<String,LoanPeriodType> ENUM_MAP;

    static {
        Map<String,LoanPeriodType> map = new ConcurrentHashMap<String,LoanPeriodType>();
        for (LoanPeriodType instance : LoanPeriodType.values()) {
            map.put(instance.getCode().toUpperCase(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static LoanPeriodType fromCode(String code) {
        return ENUM_MAP.get(code.toUpperCase());
    }
}
