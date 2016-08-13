package in.spring4buddies.application.jpa.web;

import in.spring4buddies.application.jpa.domain.Note;
import in.spring4buddies.application.jpa.repository.NoteRepository;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;

	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		Iterator<Note> notes = noteRepository.findAll().iterator();
		return IteratorUtils.toList(notes);
	}
}
