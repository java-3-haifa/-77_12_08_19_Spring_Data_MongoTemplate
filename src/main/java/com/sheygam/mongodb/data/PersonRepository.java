package com.sheygam.mongodb.data;

import com.sheygam.mongodb.data.documents.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Integer>{

}
