package com.atos.springBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.springBootDemo.model.Person;
import com.atos.springBootDemo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	public PersonController() {
		System.out.println("Person controller!!!");
	}

	@RequestMapping("/create")
	public Person addPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {

		return personService.create(firstName, lastName, age);
	}

	@RequestMapping("/getAll")
	public List<Person> getAll() {

		return personService.getAllPersons();
	}

	@RequestMapping("/getByFirstName")
	public Person getByFirstName(@RequestParam String firstName) {
		return personService.getPersonByFirstName(firstName);
	}

	@RequestMapping("/deleteAll")
	public String delete() {
		personService.deleteAllPersons();
		return "Deleted successfully!!!";

	}

	@RequestMapping("/delete")
	public String deleteByFirstName(@RequestParam String firstName) {

		personService.deletePersonByFirstName(firstName);
		return "Deleted succesfully!!!" + firstName;
	}

	@RequestMapping("/updatePerson")
	public Person update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p = personService.updatePerson(firstName, lastName, age);
		return p;
	}
}
