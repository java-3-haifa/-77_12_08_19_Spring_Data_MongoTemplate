package com.sheygam.mongodb.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class PersonCarDto {
    private String id;
    private String model;
    private String color;
    private BigDecimal price;
    private int ownerId;
}
