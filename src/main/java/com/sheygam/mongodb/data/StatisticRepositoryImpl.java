package com.sheygam.mongodb.data;

import com.sheygam.mongodb.data.documents.CarStatistic;
import com.sheygam.mongodb.data.documents.PersonCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;

import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


public class StatisticRepositoryImpl implements StatisticRepository {
    @Autowired
    MongoTemplate template;

    public List<CarStatistic> aggregateCarByPersonId() {

        TypedAggregation<PersonCar> aggregation = newAggregation(
                PersonCar.class,
                group("ownerId")
                        .sum("price").as("totalPrice")
                        .addToSet("model").as("models"),
                project("totalPrice", "models").and("_id").as("ownerId")
        );
        AggregationResults<CarStatistic> results = template.aggregate(aggregation, "sailing_cars", CarStatistic.class);
        return results.getMappedResults();
    }

    @Override
    public List<Map> getModelStatistic() {
        return template.aggregate(
                newAggregation(
                        group("model").count().as("count")
                ),
                "sailing_cars",
                Map.class
        ).getMappedResults();
    }

    @Override
    public List<Map> testStatistic() {
        return template.aggregate(
                newAggregation(group("ownerId","model"),
                        project("ownerId","model").and("ownerId").as("userId")
                ),
                "sailing_cars",
                Map.class
        ).getMappedResults();
    }
}

