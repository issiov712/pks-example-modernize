package pks.example.modernize.domain.loan.core;

import java.util.EnumSet;

public class LoanType {

    public enum LoanOption {
      
        MAY_DELAY_FIRST_INTERST_PAYMENT(0),     // can capitalize interest
        MAY_DELAY_FIRST_PRINCIPAL_PAYMENT(1),   // can provide interest only payments

        // Loan option flags

        LEVEL_PAYMENT_AMORTIZATION(1),
        LEVEL_PRINCIPAL_AMORTIZATION(2),
        BULLET_FINAL_PAYMENT(3);

        private long bitmap;

        private LoanOption(int index) {
            this.bitmap = 1 << index;
        }

    }

    private EnumSet<LoanOption> option;
    private String code;

    private LoanType(String code, EnumSet<LoanOption> option) {
        this.code = code;
        this.option = option;
    }

    public static final LoanType SIMPLE_LOAN = new LoanType("S",EnumSet.of(LoanOption.LEVEL_PAYMENT_AMORTIZATION));
    public static final LoanType BULLET_LOAN = new LoanType("B",EnumSet.of(LoanOption.MAY_DELAY_FIRST_INTERST_PAYMENT,LoanOption.MAY_DELAY_FIRST_PRINCIPAL_PAYMENT,LoanOption.BULLET_FINAL_PAYMENT));

    // // Types to select from

    // public static final EnumSet<LoanOption> SIMPLE_LOAN =
    //     EnumSet.of(LoanOption.LEVEL_PAYMENT_AMORTIZATION);

    // }
}
