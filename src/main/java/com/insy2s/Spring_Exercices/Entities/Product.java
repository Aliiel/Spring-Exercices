package com.insy2s.Spring_Exercices.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    private int id;
    private String name;
    private double price;
}
