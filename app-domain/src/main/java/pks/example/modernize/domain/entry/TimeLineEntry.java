package pks.example.modernize.domain.entry;

import java.util.List;

public interface TimeLineEntry extends Comparable<TimeLineEntry> {
	public List<TimeLineEntryItem> list();
	public void add(TimeLineEntryItem item);
	public TimeLineEntry sort();
}
