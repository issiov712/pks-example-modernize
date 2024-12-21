package pks.example.modernize.domain.tenant.model;

import java.util.List;
import java.util.UUID;

import pks.example.modernize.util.type.StringSortablePair;

public class TenantPrincipal {
	UUID id;
	String email;
	String name;
	List<UUID> tenants;
	// List<TenantPrincipalPreference> preferences;
	List<StringSortablePair<Tenant>> preferences;
}
