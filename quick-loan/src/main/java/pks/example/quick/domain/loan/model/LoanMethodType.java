package pks.example.quick.domain.loan.model;

import java.util.Arrays;
import java.util.List;


//todo: refactor to similar to LoanPeriodType

public enum LoanMethodType implements LoanMethod {
	SIMPLE_LEVEL_PAYMENT {
		public String getCode() { return "SL"; }
		public String getName() { return "Simple Level Payment Amortization"; }
		public String getDescription() { return """
			A simple loan repayment schedule where the periodic payments \
			are the same amount. \
			"""; }
	},
	SIMPLE_LEVEL_PRINCIPAL {
		public String getCode() { return "SP"; }
		public String getName() { return "Level Principal Payment Amortization"; }
		public String getDescription() { return """
			A loan repayment schedule where the periodic payments retire equal \
			principal amounts.  Therefore, the payments get smaller as you \
			get nearer the end of the loan as the interest portion of the \
			payment decreases. \
			"""; }

	};

	public static List<LoanMethod> getAllLoanTypes() {
		return Arrays.asList(
			LoanMethodType.SIMPLE_LEVEL_PAYMENT,
			LoanMethodType.SIMPLE_LEVEL_PRINCIPAL
		);
	}
}
