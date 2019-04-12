package com.bookstore.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.bookstore.models.Author;
import com.bookstore.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AuthorResources {
    
    @Autowired
    private AuthorRepository repository;

    @GetMapping("/authors")
    public List<Author> getAllAttendants() {
        
        List<Author> authors = repository.findAll();

        return authors;
    }

    @PostMapping("/authors")
    public ResponseEntity<?> saveAttendant(@RequestBody Author attendant) {
        
        Author savedAuthor = repository.save(attendant);

        URI uri = ServletUriComponentsBuilder.
            fromCurrentRequest().
            path("/{id}").
            buildAndExpand(savedAuthor.getId()).
            toUri();
        
        return ResponseEntity.created(uri).body("Nome e id do novo Autor: " + 
            savedAuthor.getName() + " - " + savedAuthor.getId());
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<?> updateAttendant(@RequestBody Author attendant, @PathVariable int id) {

        Optional<Author> authorFound = repository.findById(id);

        if (!authorFound.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        attendant.setId(id);
        repository.save(attendant);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/authors/{id}")
    public void deleteAttendant(@PathVariable int id) {
        
        Optional<Author> authorFound = repository.findById(id);

        if (authorFound.isPresent()) {
            repository.deleteById(id);
        }
    }
}