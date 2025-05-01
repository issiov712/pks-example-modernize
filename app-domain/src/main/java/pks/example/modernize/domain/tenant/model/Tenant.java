package pks.example.modernize.domain.tenant.model;

import java.util.List;
import java.util.UUID;

public class Tenant implements Comparable<Tenant> {
	UUID id;
	UUID parent;
	String name;
	List<TenantProperty> properties;

	public int compareTo(Tenant that) {
		return this.name.compareTo(that.name);
	}
}
