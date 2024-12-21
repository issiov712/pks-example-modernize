package pks.example.modernize.domain.entry.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString @SuperBuilder @Getter
public abstract class AbstractTimeLineEntry implements TimeLineEntry {
	@Builder.Default private List<TimeLineEntryItem> items = new ArrayList<TimeLineEntryItem>();
	private Date scheduled;

	AbstractTimeLineEntry() {
		scheduled = new Date(Calendar.getInstance().getTime().getTime());
	}

	AbstractTimeLineEntry(AbstractTimeLineEntryItem item) {
		items.add(item);
		scheduled = new Date(Calendar.getInstance().getTime().getTime()+10);
	}

	public int compareTo(TimeLineEntry obj) {
		AbstractTimeLineEntry that = (AbstractTimeLineEntry)obj;
		return this.scheduled.compareTo(that.scheduled);
	}

	public void add(TimeLineEntryItem item) {
		this.add((AbstractTimeLineEntryItem)item);
	}

	void add(AbstractTimeLineEntryItem item) {
		items.add(item);
	}

	public List<TimeLineEntryItem> list() {
		items = ( items == null ) ? new ArrayList<TimeLineEntryItem>() : items;
		return Collections.unmodifiableList(items);
	}

	public TimeLineEntry sort() {
		if (items != null) {
			Collections.sort(items);
		}
		return this;
	}

}
