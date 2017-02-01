package pl.devdioniz.springrest.service;

import pl.devdioniz.springrest.domain.Person;

public interface PersonService {
	
	public Iterable<Person> list();
	
	public Person create(Person person);
	
	public Person update(int id, Person person);
	
	public Person findPerson(int id);
	
	public void delete(int id);
}
