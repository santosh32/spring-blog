package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.NodeGroupNodeMap;
import in.spring4buddies.application.model.NodeGroupNodeMapPK;

public interface NodeGroupNodeMapRepository extends PagingAndSortingRepository<NodeGroupNodeMap, NodeGroupNodeMapPK> {
}
