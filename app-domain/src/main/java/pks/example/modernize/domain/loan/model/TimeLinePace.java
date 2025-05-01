package pks.example.modernize.domain.loan.model;

public enum TimeLinePace {
	TRIENNIAL,			// every three (3) years
	BIENNIAL,			// every two (2) years
	EIGHTEENMONTHS,		// every eighteen (18) months
	ANNUAL,				// every one (1) year
	NINEMONTHS,			// every nine (9) months
	SEMIANNUAL,			// every six (6) months
	TRIANNUAL,			// every four (4) months
	QUARTERLY,			// every three (3) months
	BIMONTHLY,			// every two (2) months
	MONTHLY,			// every one (1) month
	BIMONTHLY_LATE,		// the 15th and last day of the month
	BIMONTHLY_EARLY,	// the 1st and 15th of the month
	TWOWEEKS,			// every two (2) weeks
	WEEKLY				// every one (1) week
}
