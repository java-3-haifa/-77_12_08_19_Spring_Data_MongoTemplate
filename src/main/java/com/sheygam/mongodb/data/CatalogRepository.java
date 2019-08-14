package com.sheygam.mongodb.data;

import com.sheygam.mongodb.data.documents.CatalogCar;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogRepository extends MongoRepository<CatalogCar, ObjectId>,StatisticRepository {
}
