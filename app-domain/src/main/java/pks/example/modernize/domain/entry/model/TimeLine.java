package pks.example.modernize.domain.entry.model;

import java.util.List;

public interface TimeLine {
	public void add(TimeLineEntry entry);
	public int size();
	public List<TimeLineEntry> list();
	public TimeLine sort();
}
