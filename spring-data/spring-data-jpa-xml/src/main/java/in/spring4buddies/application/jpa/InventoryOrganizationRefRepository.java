package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.InventoryOrganizationRef;

public interface InventoryOrganizationRefRepository extends PagingAndSortingRepository<InventoryOrganizationRef, Integer> {
}
