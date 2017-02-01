package pl.devdioniz.springrest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.devdioniz.springrest.domain.Person;
import pl.devdioniz.springrest.exception.PersonNotFoundException;
import pl.devdioniz.springrest.service.PersonServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonServiceImpl personService;

	@Autowired
	public PersonController(PersonServiceImpl personService) {
		super();
		this.personService = personService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Person> list() {
		return personService.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person listOnePerson(@PathVariable(value = "id") int id) {
		
		Person p = personService.findPerson(id);
		
		if(p == null) {
			throw new PersonNotFoundException("Could not found person of ID = " + id);
		}
		
		return p;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Person createPerson(@RequestBody Person person) {
		return personService.create(person);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Person updatePerson(@PathVariable(value = "id") int id, @RequestBody Person person) {
		return personService.update(id, person);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable(value = "id") int id) {
		personService.delete(id);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public void handlePersonNotFound(PersonNotFoundException ex, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
}
