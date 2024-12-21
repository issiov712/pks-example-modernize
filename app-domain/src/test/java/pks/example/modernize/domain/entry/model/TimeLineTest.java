package pks.example.modernize.domain.entry.model;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import pks.example.modernize.domain.entry.model.BaseTimeLine;
import pks.example.modernize.domain.entry.model.Entry;
import pks.example.modernize.domain.entry.model.EntryItem;
import pks.example.modernize.domain.entry.model.LedgerAccount;
import pks.example.modernize.domain.entry.model.LedgerEntry;
import pks.example.modernize.domain.entry.model.LedgerItem;
import pks.example.modernize.domain.entry.model.TimeLine;
import pks.example.modernize.domain.entry.model.TimeLineEntry;

public class TimeLineTest {

	@Test
	public void checkTimeLineUsefullness() {

		TimeLine tl = (TimeLine) new BaseTimeLine();
		tl.add(new LedgerEntry());
		tl.add(new Entry());
		tl.add(LedgerEntry.builder().scheduled(Date.valueOf("2024-12-02")).build());
		tl.add(
			Entry.builder()
				.effective(Date.valueOf("2024-12-22"))
				.scheduled(Date.valueOf("2024-12-31"))
				.build());

		assertEquals(4, tl.size());

		Entry e = Entry.builder()
			.effective(Date.valueOf("2024-11-12"))
			.scheduled(Date.valueOf("2024-11-21"))
			.build();
		e.add(EntryItem.builder().name("tom").build());
		e.add(EntryItem.builder().name("joe").build());
		tl.add(e);

		LedgerItem li = LedgerItem.builder()
			.amount(Money.of(10,"USD"))
			.name("sammy")
			.creditAccount(new LedgerAccount("000.44.33","8883.12.31","30.21"))
			.debitAccount(new LedgerAccount("764.44.33","8883.12.31","30.21"))
			.build();
		LedgerEntry le = LedgerEntry.builder()
			.scheduled(Date.valueOf("2024-11-21"))
			.posted(Date.valueOf("2024-11-30"))
			.build();
		le.add(li);
		tl.add(le);

		TimeLine tl2 = (TimeLine) new BaseTimeLine();

		for (TimeLineEntry tle : tl.list()) {
			if (tle != null && tle.getClass().equals(Entry.class)) {
				System.out.println("creating a ledgerentry");
				tl2.add(LedgerEntry.from((Entry)tle,
					new LedgerAccount("000.44.33","8883.12.31","30.21"),
					new LedgerAccount("000.44.33","8883.12.31","30.21")));
			} else {
				tl2.add(tle);
			}
		}

		
		for (TimeLineEntry tle : tl2.sort().list()) {
			System.out.println("entry: " + tle.toString());
		}
	}
}
