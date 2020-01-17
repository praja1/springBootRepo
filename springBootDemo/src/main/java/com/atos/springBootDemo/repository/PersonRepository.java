package com.atos.springBootDemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.atos.springBootDemo.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}

// to encapsulate the data used for retreival,storage,updation and deletion.