package com.sheygam.mongodb.data.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "persons")
public class Person {
    @Id
    private int id;
    private String name;
    private String phone;
}
