package pks.example.quick.domain.loan.model;

import java.sql.Date;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum LoanPhaseType {
	PHASE_A_FUNDS_DISBURSEMENT (
		"A",
		"Phase A: Funds Disbursement & Loan Start",
		"""
		This phase creates the inital entry in the loan repayment schedule \
		which identifies the date of the funds disbursement to the customer. \
		"""
	),
	PHASE_B_INITIAL_INTEREST_ACCRUAL(
		"B",
		"Phase B: Initial Interest Accrual",
		"""
		This phase is prior to the first statement and is typically less than \
		two periods in length.  It is used to set the initial date of payments \
		and therefore the number day of the month on which payments are due. \
		"""
	),
	PHASE_C_CAPITALIZING_INTEREST(
		"C",
		"Phase C: Interest Capitalization",
		"""
		In this phase no payments are due and the interest in capitalized into \
		the loan balance, though tracked separately. \
		"""
	),
	PHASE_D_INTEREST_ONLY_PAYMENTS(
		"D",
		"Phase D:  Interest Only Payments",
		"""
		During this phase the payments are equal to the accrued interest during \
		the period.  No payments are applied to the principal or capitalized \
		balances. \
		"""
	),
	PHASE_E_INTEREST_AND_PRINCIPAL(
		"E",
		"Phase E:  Payments to Both Principal and Interest",
		"""
		This is the phase when you are making progress in some manner in \
		retiring the capitalized interest and then principal balance(s). \
		"""
	),
	PHASE_F_FINAL_PAYMENT_AT_MATURITY(
		"F",
		"Phase F:  Final Payment at Current Loan Maturity",
		"""
		This is the final payment on the loan.  Accrued period interest and all \
		outstanding balances are due. \
		"""
	),
	PHASE_G_AMORTIZATION_CALCULATION_ONLY(
		"G",
		"Phase G:  Additional Amortization Calculation Periods",
		"""
		Periods after the loan payoff date used to lower or shape the \
		the amortization curve, lowering the payment rate by making payments \
		as if the term of the loan was longer than it actually is.  This \
		results in a final bullet or lump sum type payement to retire the loan. \
		"""
	);

	private final String ENUM_CODE;
	private static final Map<String,LoanPhaseType> ENUM_CODE_MAP;
	private final String ENUM_NAME;
	private final String ENUM_DESC;

	private LoanPhaseType(final String code, final String name, final String description) {
		this.ENUM_CODE = code;
		this.ENUM_NAME = name;
		this.ENUM_DESC = description;
	}


    static {
        Map<String,LoanPhaseType> map = new ConcurrentHashMap<String,LoanPhaseType>();
        for (LoanPhaseType instance : LoanPhaseType.values()) {
            map.put(instance.getCode().toUpperCase(),instance);
        }
        ENUM_CODE_MAP = Collections.unmodifiableMap(map);
    }


    public static LoanPhaseType fromCode(String code) {
        return ENUM_CODE_MAP.get(code.toUpperCase());
    }


	public String getCode() { return this.ENUM_CODE; }
	public String getName() { return this.ENUM_NAME; }
	public String getDescription() { return this.ENUM_DESC; }


	public static LoanPhaseType fromLoan(final LoanAggregate loan, final Date date) {
		if (date.compareTo(loan.getCurrentMaturityDate()) >= 0) {
			return LoanPhaseType.PHASE_F_FINAL_PAYMENT_AT_MATURITY;
		
		} else if (date.compareTo(loan.getFirstPrincipalPaymentDate()) >= 0) {
			return LoanPhaseType.PHASE_E_INTEREST_AND_PRINCIPAL;

		} else if (date.compareTo(loan.getFirstInterestPaymentDate()) >= 0) {
			return LoanPhaseType.PHASE_D_INTEREST_ONLY_PAYMENTS;

		} else if (date.compareTo(loan.getFirstStatementDate()) >= 0) {
			return LoanPhaseType.PHASE_C_CAPITALIZING_INTEREST;

		} else if (date.compareTo(loan.getFundsDisbursementDate()) > 0) {
			return LoanPhaseType.PHASE_B_INITIAL_INTEREST_ACCRUAL;
		}

		return LoanPhaseType.PHASE_A_FUNDS_DISBURSEMENT;
	}

}
