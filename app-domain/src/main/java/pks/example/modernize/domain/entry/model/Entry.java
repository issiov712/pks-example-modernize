package pks.example.modernize.domain.entry.model;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder @Getter @ToString(callSuper = true) @NoArgsConstructor
public class Entry extends AbstractTimeLineEntry {
	private Date effective;

	// public List<EntryItem> list() {
	// 	return (List<EntryItem>)super.list();
	// }
}
