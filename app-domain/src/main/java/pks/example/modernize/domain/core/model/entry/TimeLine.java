package pks.example.modernize.domain.core.model.entry;

import java.util.List;

public interface TimeLine {
	public void add(TimeLineEntry entry);
	public int size();
	public List<TimeLineEntry> list();
	public TimeLine sort();
}
