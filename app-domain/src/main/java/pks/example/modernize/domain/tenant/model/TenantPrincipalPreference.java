package pks.example.modernize.domain.tenant.model;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class TenantPrincipalPreference extends ImmutablePair<String,String> {

	TenantPrincipalPreference(final String label, final String value) {
		super(label,value);
	}

	public String label() { return this.left; }
	public String value() { return this.right;}
 }
