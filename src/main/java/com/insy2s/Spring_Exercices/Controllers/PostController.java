package com.insy2s.Spring_Exercices.Controllers;

import com.insy2s.Spring_Exercices.Entities.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final ArrayList<Post> posts = new ArrayList<>();
    private int currentId = posts.size();

    @PostMapping
    public ResponseEntity<String> postPost(@RequestBody Post post){
        post.setId(++currentId);
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body("Article ajouté avec l'ID " + (post.getId()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> putPost(@PathVariable int id, @RequestBody Post updatedPost){

        for (Post post : posts) {

            if (post.getId() == id) {

                post.setTitle(updatedPost.getTitle());
                post.setContent(updatedPost.getContent());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id){

        for (Post post : posts) {

            if (post.getId() == id) {

                posts.remove(post);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(posts);
    }
}
