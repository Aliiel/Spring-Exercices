package com.insy2s.Spring_Exercices.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {

    private final HashMap<Integer, String> users = new HashMap<>();

    public void loadUsers() {
        users.put(1, "Mary Hopkins");
        users.put(2, "Jennifer Brooks");
        users.put(3, "Elizabeth Patters");
        users.put(4, "Tony Baja");
        users.put(5, "Lisa Lawn");
    }

    @GetMapping("/{id}")
    public String getUserName(@PathVariable int id) {
        loadUsers();
        return "User with id " + id + " is " + users.get(id);
    }

    @GetMapping("/all")
    public Collection<String> getAllUsers() {
        loadUsers();
        return users.values();
    }
}
