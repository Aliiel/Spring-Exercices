package com.insy2s.Spring_Exercices.Controllers;

import com.insy2s.Spring_Exercices.Entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController2 {

    private final ArrayList<User> users = new ArrayList<>();
    private int currentId = users.size();

    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody User user){
        user.setId(++currentId);
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur ajouté avec l'ID " + (user.getId()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> putUser(@PathVariable int id, @RequestBody User updatedUser){

        for (User user : users) {

            if (user.getId() == id) {

                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("User updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){

        for (User user : users) {

            if (user.getId() == id) {

                users.remove(user);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("User deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(users);
    }
}
