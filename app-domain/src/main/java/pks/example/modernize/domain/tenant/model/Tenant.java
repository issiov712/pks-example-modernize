package pks.example.modernize.domain.tenant.model;

import java.util.List;
import java.util.UUID;

import pks.example.modernize.util.type.StringPair;

public class Tenant implements Comparable<Tenant> {
	UUID id;
	UUID parent;
	String name;
	// List<TenantProperties> properties;
	List<StringPair> properties;

	public int compareTo(Tenant that) {
		return this.name.compareTo(that.name);
	}
}
