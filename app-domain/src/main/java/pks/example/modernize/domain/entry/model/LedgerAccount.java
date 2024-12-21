package pks.example.modernize.domain.entry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder @Getter @ToString @AllArgsConstructor
public class LedgerAccount {
	private final LedgerCode account;
	private final LedgerCode project;
	private final LedgerCode orgUnit;

	LedgerAccount(final String account, final String project, final String orgUnit) {
		this.account = new LedgerCode(account);
		this.project = new LedgerCode(project);
		this.orgUnit = new LedgerCode(orgUnit);
	}
}
