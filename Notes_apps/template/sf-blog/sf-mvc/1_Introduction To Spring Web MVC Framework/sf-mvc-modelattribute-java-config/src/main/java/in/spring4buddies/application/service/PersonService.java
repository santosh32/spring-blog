package in.spring4buddies.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.spring4buddies.application.command.Person;

/**
 * Service for processing Persons.
 */
@Service("personService")
@Transactional
public class PersonService {

	protected static Logger logger = Logger.getLogger("service");

	private HashMap<Integer, Person> database = new HashMap<Integer, Person>();

	/**
	 * Initialize a list of persons
	 */
	private void init() {
		// New person
		Person person = new Person();
		person.setId(1);
		person.setFirstName("John");
		person.setLastName("Smith");
		person.setCurrency("Dollar");
		person.setMoney(1500.00);

		// Add to list
		database.put(1, person);

		// New person
		person = new Person();
		person.setId(2);
		person.setFirstName("Jane");
		person.setLastName("Adams");
		person.setCurrency("Yen");
		person.setMoney(1000.00);

		// Add to list
		database.put(2, person);

		// New person
		person = new Person();
		person.setId(3);
		person.setFirstName("Mike");
		person.setLastName("Polaski");
		person.setCurrency("Euro");
		person.setMoney(2000.00);

		// Add to list
		database.put(3, person);
	}

	public PersonService() {
		// Initialize dummy database
		init();
	}

	/**
	 * Retrieves all persons
	 * 
	 * @return a list of persons
	 */
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");

		// Initialize our array
		List<Person> persons = new ArrayList<Person>();

		// Iterate the database
		for (Map.Entry<Integer, Person> entry : database.entrySet()) {
			persons.add(entry.getValue());
		}

		// Return all persons
		return persons;
	}

	/**
	 * Retrieves a person based on his id
	 * 
	 * @param id
	 *            the identifier of the person
	 * @return a person
	 */
	public Person get(Integer id) {
		logger.debug("Retrieving person based on his id");
		return database.get(id);
	}

	/**
	 * Edits an existing person
	 */
	public void edit(Person person) {
		logger.debug("Editing existing person");

		// Note this is not the best way to update a data!

		// Delete existing user
		database.remove(person.getId());
		// Add updated user
		database.put(person.getId(), person);
	}

}
