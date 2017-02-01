package pl.devdioniz.springrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.devdioniz.springrest.domain.Person;
import pl.devdioniz.springrest.repository.PersonRepository;

@SpringBootApplication
public class RestExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestExerciseApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(PersonRepository personRepository) {
		return args -> {
			Person p = new Person("d2", "d2@o2.pl", "male");
			personRepository.save(p);
		};
	}
}
