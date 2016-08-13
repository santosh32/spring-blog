package in.spring4buddies.application.jpa;

import in.spring4buddies.application.jpa.domain.Note;
import in.spring4buddies.application.jpa.domain.Tag;
import in.spring4buddies.application.jpa.repository.NoteRepository;
import in.spring4buddies.application.jpa.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories
@EnableTransactionManagement
@EnableWebMvc
public class JpaBootApplication { // implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(
				JpaBootApplication.class, args);

//		NoteRepository noteRepository = context.getBean(NoteRepository.class);
//		TagRepository tagRepository = context.getBean(TagRepository.class);

//		System.out.println("== performing the insert operation ==");
//
//		Tag tag = new Tag();
//		tag.setName("Spring projects");
//		tagRepository.save(tag);
//
//		Tag tag1 = new Tag();
//		tag1.setName("Apache projects");
//		tagRepository.save(tag1);
//
//		Tag tag2 = new Tag();
//		tag2.setName("Open source");
//		tagRepository.save(tag2);
//
//		Note note = new Note();
//		note.setBody("Takes an opinionated view of building production-ready Spring applications.");
//		note.setTitle("Spring Boot");
//		List<Tag> tagNote = new ArrayList<Tag>();
//		tagNote.add(tag);
//		tagNote.add(tag2);
//		note.setTags(tagNote);
//
//		Note note1 = new Note();
//		note1.setBody("Core support for dependency injection, transaction management, web applications, data access, messaging, testing and more.");
//		note1.setTitle("Spring Framework");
//		List<Tag> tagNote1 = new ArrayList<Tag>();
//		tagNote1.add(tag);
//		tagNote1.add(tag2);
//		note1.setTags(tagNote1);
//
//		Note note2 = new Note();
//		note2.setBody("Extends the Spring programming model to support the well-known Enterprise Integration Patterns.");
//		note2.setTitle("Spring Integration");
//		List<Tag> tagNote2 = new ArrayList<Tag>();
//		tagNote2.add(tag);
//		tagNote2.add(tag2);
//		note2.setTags(tagNote2);
//
//		Note note3 = new Note();
//		note3.setBody("Apache Tomcat is an open source software implementation of the Java Servlet and JavaServer Pages technologies.");
//		note3.setTitle("Tomcat");
//		List<Tag> tagNote3 = new ArrayList<Tag>();
//		tagNote3.add(tag1);
//		tagNote3.add(tag2);
//		note3.setTags(tagNote3);
//
//		noteRepository.save(note);
//		noteRepository.save(note1);
//		noteRepository.save(note2);
//		noteRepository.save(note3);
//
//		System.out.println("== performing the inserted successfully ==");

	}

}
