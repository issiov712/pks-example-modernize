package pks.example.modernize.domain.entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true) @SuperBuilder
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractTimeLine implements TimeLine {
	List<TimeLineEntry> entries = new ArrayList<TimeLineEntry>();

	public void add(TimeLineEntry entry) {
		this.add((AbstractTimeLineEntry)entry);
	}

	public void add(AbstractTimeLineEntry entry) { 
		entries.add(entry);
	}

	void add(AbstractTimeLineEntryItem item) {
		entries.add(new AbstractTimeLineEntry(item));
	}

	public int size() { 
		return entries.size(); 
	}

	public List<TimeLineEntry> list() {
		entries = ( entries == null ) ? new ArrayList<TimeLineEntry>() : entries;
		return Collections.unmodifiableList(entries);
	}

	public TimeLine sort() {
		if (entries != null) {
			Collections.sort(entries);
			for (TimeLineEntry e : entries) {
				e.sort();
			}
		}
		return this;
	}
}
