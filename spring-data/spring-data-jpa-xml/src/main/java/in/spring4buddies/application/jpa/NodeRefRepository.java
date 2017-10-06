package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.NodeRef;
import in.spring4buddies.application.model.NodeRefPK;

public interface NodeRefRepository extends PagingAndSortingRepository<NodeRef, NodeRefPK> {
}
