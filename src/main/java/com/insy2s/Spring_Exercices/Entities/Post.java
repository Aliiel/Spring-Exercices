package com.insy2s.Spring_Exercices.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    private int id;
    private String title;
    private String content;
}
