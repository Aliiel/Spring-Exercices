package com.insy2s.Spring_Exercices.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {

    private int id;
    private String room;
    private LocalDate date;
}
