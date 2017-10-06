package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.NodeFulfillmentTypeMap;
import in.spring4buddies.application.model.NodeFulfillmentTypeMapPK;

public interface NodeFulfillmentTypeMapRepository extends PagingAndSortingRepository<NodeFulfillmentTypeMap, NodeFulfillmentTypeMapPK> {
}
