package com.sheygam.mongodb.data;

import com.sheygam.mongodb.data.documents.PersonCar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonCarRepository extends MongoRepository<PersonCar,String> {
}
