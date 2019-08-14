package com.sheygam.mongodb.data.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "catalog")
public class CatalogCar {
    @Id
    private ObjectId id;
    private String model;
    private List<String> colors;
    private double price;
}
