package com.sheygam.mongodb.controller;

import com.sheygam.mongodb.data.PersonRepository;
import com.sheygam.mongodb.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class PersonController {
    @Autowired
    PersonRepository repository;

    @GetMapping("person/all")
    public List<PersonDto> getAllPersons() {
        return repository.findAll().stream()
                .map(doc -> PersonDto.builder()
                        .id(doc.getId())
                        .phone(doc.getPhone())
                        .name(doc.getName())
                        .build())
                .collect(toList());
    }

    @GetMapping("person/{id}")
    public PersonDto getPersonById(@PathVariable("id")Integer id) {
        return repository.findById(id)
                .map(Mapper::map)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"User with id:"+id+" does not exist"));
    }

    @PostMapping("person")
    public void addPerson(@RequestBody PersonDto person) {
        if (repository.existsById(person.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Person already exist");
        }
        repository.save(Mapper.map(person));
    }

    @PutMapping("person")
    public void updatePerson(@RequestBody PersonDto person) {
        if (!repository.existsById(person.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with id: " + person.getId() + " does not exist");
        }
        repository.save(Mapper.map(person));

    }

    @DeleteMapping("person/{id}")
    public void deletePerson(@PathVariable("id")Integer id){
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User with id: " + id + "does not exist");
        }
        repository.deleteById(id);
    }


}
