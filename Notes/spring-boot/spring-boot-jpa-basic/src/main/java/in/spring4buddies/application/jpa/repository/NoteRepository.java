package in.spring4buddies.application.jpa.repository;

import in.spring4buddies.application.jpa.domain.Note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

}
