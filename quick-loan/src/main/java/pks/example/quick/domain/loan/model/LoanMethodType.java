package pks.example.quick.domain.loan.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//todo: refactor to similar to LoanPeriodType

public enum LoanMethodType implements LoanCalculatorReferrer {
	SIMPLE_LEVEL_PAYMENT (
		"SL",
		"Simple Level Payment Amortization",
		"""
		A simple loan repayment schedule where the periodic payments \
		are the same amount. \
		"""
		),
	SIMPLE_LEVEL_PRINCIPAL (
		"SP",
		"Level Principal Payment Amortization",
		"""
		A loan repayment schedule where the periodic payments retire equal \
		principal amounts.  Therefore, the payments get smaller as you \
		get nearer the end of the loan as the interest portion of the \
		payment decreases. \
		"""
		);

	private final String ENUM_CODE;
	private static final Map<String,LoanMethodType> ENUM_CODE_MAP;
	private final String ENUM_NAME;
	private final String ENUM_DESC;

	private LoanMethodType(final String code, final String name, final String description) {
		ENUM_CODE = code;
		ENUM_NAME = name;
		ENUM_DESC = description;
	}

    static {
        Map<String,LoanMethodType> map = new ConcurrentHashMap<String,LoanMethodType>();
        for (LoanMethodType instance : LoanMethodType.values()) {
            map.put(instance.getCode().toUpperCase(),instance);
        }
        ENUM_CODE_MAP = Collections.unmodifiableMap(map);
    }

    public static LoanMethodType fromCode(String code) {
        return ENUM_CODE_MAP.get(code.toUpperCase());
    }

	public String getCode() { return this.ENUM_CODE; }
	public String getName() { return this.ENUM_NAME; }
	public String getDescription() { return this.ENUM_DESC; }

	public static List<LoanMethodType> getAllLoanTypes() {
		return Arrays.asList(
			LoanMethodType.SIMPLE_LEVEL_PAYMENT,
			LoanMethodType.SIMPLE_LEVEL_PRINCIPAL
		);
	}

	public LoanAggregate calculateLoanSchedule(LoanAggregate loan) {
		return loan;
	}
}
