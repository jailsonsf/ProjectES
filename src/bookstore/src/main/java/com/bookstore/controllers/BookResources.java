package com.bookstore.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.bookstore.models.Book;
import com.bookstore.repository.BookRepository;

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
public class BookResources {
    
    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public List<Book> getAllAttendants() {
        
        List<Book> books = repository.findAll();

        return books;
    }

    @PostMapping("/books")
    public ResponseEntity<?> saveAttendant(@RequestBody Book attendant) {
        
        Book savedBook = repository.save(attendant);

        URI uri = ServletUriComponentsBuilder.
            fromCurrentRequest().
            path("/{id}").
            buildAndExpand(savedBook.getId()).
            toUri();
        
        return ResponseEntity.created(uri).body("Nome e id do novo Livro: " + 
            savedBook.getTitle() + " - " + savedBook.getId());
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateAttendant(@RequestBody Book attendant, @PathVariable int id) {

        Optional<Book> bookFound = repository.findById(id);

        if (!bookFound.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        attendant.setId(id);
        repository.save(attendant);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/books/{id}")
    public void deleteAttendant(@PathVariable int id) {
        
        Optional<Book> bookFound = repository.findById(id);

        if (bookFound.isPresent()) {
            repository.deleteById(id);
        }
    }
}