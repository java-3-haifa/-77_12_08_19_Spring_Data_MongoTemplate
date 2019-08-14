package com.sheygam.mongodb.utils;

import com.sheygam.mongodb.controller.CatalogCarDto;
import com.sheygam.mongodb.controller.PersonCarDto;
import com.sheygam.mongodb.controller.PersonDto;
import com.sheygam.mongodb.data.documents.CatalogCar;
import com.sheygam.mongodb.data.documents.Person;
import com.sheygam.mongodb.data.documents.PersonCar;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class Mapper {
    public static PersonDto map(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .phone(person.getPhone())
                .build();
    }

    public static PersonCarDto map(PersonCar car){
        return PersonCarDto.builder()
                .id(car.getId())
                .color(car.getColor())
                .model(car.getModel())
                .price(BigDecimal.valueOf(car.getPrice()))
                .ownerId(car.getOwnerId())
                .build();

    }

    public static Person map(PersonDto person) {
        return Person.builder()
                .id(person.getId())
                .name(person.getName())
                .phone(person.getPhone())
                .build();
    }

    public static PersonCar map(PersonCarDto car) {
        return PersonCar.builder()
                .id(car.getId())
                .color(car.getColor())
                .model(car.getModel())
                .price(car.getPrice().doubleValue())
                .ownerId(car.getOwnerId())
                .build();
    }

    public static CatalogCar map(CatalogCarDto car) {
        ObjectId id = null;
        if(car.getId()!= null){
            id = new ObjectId(car.getId());
        }
        return CatalogCar.builder()
                .model(car.getModel())
                .id(id)
                .price(car.getPrice().doubleValue())
                .colors(car.getColors())
                .build();
    }

    public static CatalogCarDto map(CatalogCar car) {
        return CatalogCarDto.builder()
                .id(car.getId().toHexString())
                .colors(car.getColors())
                .price(BigDecimal.valueOf(car.getPrice()))
                .model(car.getModel())
                .build();
    }
}
