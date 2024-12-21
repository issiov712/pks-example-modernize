package pks.example.modernize.domain.core.model.entry;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString @AllArgsConstructor
public class LedgerCode implements Comparable<LedgerCode> {
	final static char SEGMENT_SEPARATOR = '.';
	private final String code;
	private final String name;

	LedgerCode(final String code) {
		this.code = code;
		this.name = "default description for code: '" + code + "'";
	}

	public int compareTo(final LedgerCode that) {
		return this.code.compareTo(that.code);
	}

	public int level() {
		if (code != null) {
			return StringUtils.countMatches(code,SEGMENT_SEPARATOR);
		}
		
		return -1;
	}

	public String[] segments() {
		return code.split(String.valueOf(SEGMENT_SEPARATOR));
	}
}