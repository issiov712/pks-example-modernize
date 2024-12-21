package pks.example.modernize.domain.entry;

import java.sql.Date;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true) @SuperBuilder
@NoArgsConstructor
public class LedgerEntry extends Entry {
	private Date posted;
	
	public static LedgerEntry from(Entry entry, LedgerAccount credit, LedgerAccount debit) {
		LedgerEntry le = LedgerEntry.builder()
			.scheduled(entry.getScheduled())
			.effective(entry.getEffective())
			.build();
		for (TimeLineEntryItem ei : entry.list()) {
			LedgerItem li = LedgerItem.from((EntryItem)ei,credit,debit);
		}
		return le;
	}
}
