package com.insy2s.Spring_Exercices.Controllers;

import com.insy2s.Spring_Exercices.Entities.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int currentId = tasks.size() - 1;

    @PostMapping
    public ResponseEntity<String> postTask(@RequestBody Task task){
        task.setId(++currentId);
        tasks.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tâche ajoutée avec l'ID " + (task.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putTask(@PathVariable int id, @RequestBody Task updatedTask){
        for (Task task : tasks) {

            if (task.getId() == id) {
                task.setTitle(updatedTask.getTitle());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task updated");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }


    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(){

        return ResponseEntity.ok(tasks);
    }
}
