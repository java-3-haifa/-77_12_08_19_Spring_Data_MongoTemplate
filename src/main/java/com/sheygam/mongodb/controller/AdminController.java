package com.sheygam.mongodb.controller;

import com.sheygam.mongodb.data.CatalogRepository;
import com.sheygam.mongodb.data.PersonCarRepository;
import com.sheygam.mongodb.data.documents.CarStatistic;
import com.sheygam.mongodb.utils.Mapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@RestController
public class AdminController {
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    PersonCarRepository personCarRepository;

    @PostMapping("catalog/car")
    public String addCar(@RequestBody CatalogCarDto car){
        if(car.getId()!=null && catalogRepository.existsById(new ObjectId(car.getId()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"car with id:"+car.getId()+" already exist");
        }
        return catalogRepository.save(Mapper.map(car)).getId().toHexString();
    }

    @GetMapping("catalog/car/all")
    public List<CatalogCarDto> getAllCars(){
        return catalogRepository.findAll().stream().map(Mapper::map).collect(toList());
    }

    @PostMapping("sail")
    public void addCar(@RequestBody PersonCarDto car){
        personCarRepository.save(Mapper.map(car));
    }

    @GetMapping("statistic/persons")
    public List<CarStatistic> statByPersons(){
        return catalogRepository.aggregateCarByPersonId();
    }

    @GetMapping("statistic/model")
    public List<Map> statByModel(){
        return catalogRepository.getModelStatistic();
    }

    @GetMapping("statistic/test")
    public List<Map> test(){
        return catalogRepository.testStatistic();
    }
}
