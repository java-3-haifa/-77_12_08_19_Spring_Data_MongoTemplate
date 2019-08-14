package com.sheygam.mongodb.data.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Document(collection = "sailing_cars")
public class PersonCar {
    @Id
    private String id;
    @Indexed
    private String model;
    private String color;
    private double price;
    @Indexed
    private int ownerId;
}
