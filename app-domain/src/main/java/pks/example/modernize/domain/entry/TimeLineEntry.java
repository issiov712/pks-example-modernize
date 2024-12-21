package pks.example.modernize.domain.entry;

import java.util.List;

public interface TimeLineEntry extends Comparable<TimeLineEntry> {
	List<TimeLineEntryItem> list();
	void add(TimeLineEntryItem item);

}
