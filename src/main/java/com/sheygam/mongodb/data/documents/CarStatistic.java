package com.sheygam.mongodb.data.documents;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CarStatistic {
    private int ownerId;
    private Set<String> models;
    private double totalPrice;
}
