package pks.example.modernize.domain.entry;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true) 
@SuperBuilder
@Getter
public class LedgerItem extends EntryItem {
	private LedgerAccount creditAccount;
	private LedgerAccount debitAccount;

	public static LedgerItem from(EntryItem item, LedgerAccount credit, LedgerAccount debit) {
		return LedgerItem.builder()
			.creditAccount(credit)
			.debitAccount(debit)
			.amount(item.getAmount())
			.name(item.getName())
			.build();
	}
}
