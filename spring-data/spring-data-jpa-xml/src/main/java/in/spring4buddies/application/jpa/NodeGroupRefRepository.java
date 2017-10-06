package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.NodeGroupRef;
import in.spring4buddies.application.model.NodeGroupRefPK;

public interface NodeGroupRefRepository extends PagingAndSortingRepository<NodeGroupRef, NodeGroupRefPK> {
}
