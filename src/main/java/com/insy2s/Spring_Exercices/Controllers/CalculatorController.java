package com.insy2s.Spring_Exercices.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b)
    {
        return "Résultat : " + (a+b);
    }

    @GetMapping("/multiply/{a}/{b}")
    public String multiply(@PathVariable Integer a, @PathVariable Integer b){
        return "Résultat : " + (a*b);
    }
}
