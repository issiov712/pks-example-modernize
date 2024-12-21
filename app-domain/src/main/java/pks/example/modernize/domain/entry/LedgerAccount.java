package pks.example.modernize.domain.entry;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString 
@Builder
@Getter
@AllArgsConstructor
public class LedgerAccount {
	private String accountCode;
	private String projectCode;
	private String orgUnitCode;

	int level(String code) {
		if (code != null) {
			return StringUtils.countMatches(code,".");
		}
		
		return -1;
	}

	public int accountLevel() {
		return level(this.accountCode);
	}

	public int projecLevel() {
		return level(this.projectCode);
	}

	public int orgUnitLevel() {
		return level(this.orgUnitCode);
	}
}
