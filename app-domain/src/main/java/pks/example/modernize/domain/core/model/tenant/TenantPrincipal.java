package pks.example.modernize.domain.core.model.tenant;

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
