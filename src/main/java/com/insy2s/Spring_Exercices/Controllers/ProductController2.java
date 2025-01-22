package com.insy2s.Spring_Exercices.Controllers;

import com.insy2s.Spring_Exercices.Entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController2 {

    private final ArrayList<Product> products = new ArrayList<>();
    private int currentId = products.size();

    @PostMapping
    public ResponseEntity<String> postProduct(@RequestBody Product product){
        product.setId(++currentId);
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produit ajouté avec l'ID " + (product.getId()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> putProduct(@PathVariable int id, @RequestBody Product updatedProduct){

        for (Product product : products) {

            if (product.getId() == id) {

                product.setPrice(updatedProduct.getPrice());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){

        for (Product product : products) {

            if (product.getId() == id) {

                products.remove(product);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(products);
    }

}
