package pks.example.modernize.domain.entry;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true) @SuperBuilder
@NoArgsConstructor
@Getter
public class Entry extends AbstractTimeLineEntry {
	private Date effective;

	// public List<EntryItem> list() {
	// 	return (List<EntryItem>)super.list();
	// }
}
