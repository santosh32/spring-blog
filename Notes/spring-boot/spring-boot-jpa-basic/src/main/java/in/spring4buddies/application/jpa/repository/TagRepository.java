package in.spring4buddies.application.jpa.repository;

import in.spring4buddies.application.jpa.domain.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
