package pks.example.modernize.domain.entry;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString @SuperBuilder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AbstractTimeLineEntryItem implements TimeLineEntryItem {
	private static Integer count = Integer.valueOf(0);
	@Builder.Default private Integer sequence = ++count;

	public int compareTo(TimeLineEntryItem that) {
		return 0;
	}
}
