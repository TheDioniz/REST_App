package pl.devdioniz.springrest.repository;

import org.springframework.data.repository.CrudRepository;

import pl.devdioniz.springrest.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
