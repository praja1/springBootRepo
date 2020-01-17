package com.atos.springBootDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.atos.springBootDemo.model.Person;
import com.atos.springBootDemo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public PersonService() {
		System.out.println("person service object creared!!!");
	}

	public Person create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}

	public List<Person> getAllPersons() {

		return personRepository.findAll();
	}

	public Person getPersonByFirstName(String firstName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(firstName));

		return mongoTemplate.findOne(query, Person.class);

	}

	public String deleteAllPersons() {
		personRepository.deleteAll();
		return "deleted successfully ";
	}

	public void deletePersonByFirstName(String firstName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(firstName));

		Person p = mongoTemplate.findOne(query, Person.class);

		personRepository.delete(p);

	}

	//update operation
	public Person updatePerson(String firstName, String lastName, int age) {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(firstName));
		Person p = mongoTemplate.findOne(query, Person.class);
		
		p.setLastName(lastName);
		p.setAge(age);

		return personRepository.save(p);
	}

}
