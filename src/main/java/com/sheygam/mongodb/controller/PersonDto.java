package com.sheygam.mongodb.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PersonDto {
    private int id;
    private String name;
    private String phone;
}
