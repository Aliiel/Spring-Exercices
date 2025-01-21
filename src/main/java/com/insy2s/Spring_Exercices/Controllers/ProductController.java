package com.insy2s.Spring_Exercices.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    private static final Map<Integer, String> products = new HashMap<>();

    static {
        products.put(0, "PC");
        products.put(1, "PS5");
        products.put(2, "TV");
        products.put(3, "Feuille A4");
        products.put(4, "Bouteille d'eau");
    }

    @GetMapping("/product/{id}")
    public String getById(@PathVariable int id) {
        return products.getOrDefault(id, "Produit n'existe pas");
    }

    @GetMapping("/product/add")
    public String add(@RequestParam String name){
        return products.put(products.size(), name);
    }

    @GetMapping("product/all")
    public Map<Integer,String> getAll(){
        return products;
    }

}
