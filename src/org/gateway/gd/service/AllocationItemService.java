package org.gateway.gd.service;

import org.gateway.gd.domain.AllocationItem;

public interface AllocationItemService {

	AllocationItem getById(Long id);

	void delete(Long id);

	void save(AllocationItem allocationItem);

	void update(AllocationItem allocationItem);

}
