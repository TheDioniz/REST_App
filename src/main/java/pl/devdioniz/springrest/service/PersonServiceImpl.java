package pl.devdioniz.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.devdioniz.springrest.domain.Person;
import pl.devdioniz.springrest.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public Iterable<Person> list() {
		return personRepository.findAll();
	}

	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person update(int id, Person person) {
		Person p = personRepository.findOne(id);
		p.setEmail(person.getEmail());
		p.setName(person.getName());
		p.setSex(person.getSex());
		return personRepository.save(p);
	}

	@Override
	public Person findPerson(int id) {
		return personRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		personRepository.delete(id);
	}

}
