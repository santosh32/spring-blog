package in.spring4buddies.application.service;

import in.spring4buddies.application.jpa.NodeRefRepository;
import in.spring4buddies.application.model.NodeRef;

public class NodeRefService {

	private NodeRefRepository nodeRefRepository;

	private NodeRefService(NodeRefRepository nodeRefRepository) {
		this.nodeRefRepository = nodeRefRepository;

	}

	public void save(NodeRef nodeRef) {
		nodeRefRepository.save(nodeRef);
	}
}
