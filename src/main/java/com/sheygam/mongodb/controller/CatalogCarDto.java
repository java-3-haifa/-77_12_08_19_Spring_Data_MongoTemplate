package com.sheygam.mongodb.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CatalogCarDto {
    private String id;
    private String model;
    private List<String> colors;
    private BigDecimal price;
}
