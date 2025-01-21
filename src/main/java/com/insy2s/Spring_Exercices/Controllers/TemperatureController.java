package com.insy2s.Spring_Exercices.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    @GetMapping("/convert")
    public String convert(@RequestParam int celsius) {
        return celsius + "°C = " + ((celsius* 9/5)+32) + "°F";
    }
}
