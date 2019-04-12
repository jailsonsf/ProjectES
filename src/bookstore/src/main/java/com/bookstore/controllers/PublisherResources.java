package com.bookstore.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.bookstore.models.BookPublisher;
import com.bookstore.repository.PublisherRepository;

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
public class PublisherResources {
    
    @Autowired
    private PublisherRepository repository;

    @GetMapping("/publishers")
    public List<BookPublisher> getAllAttendants() {
        
        List<BookPublisher> publishers = repository.findAll();

        return publishers;
    }

    @PostMapping("/publishers")
    public ResponseEntity<?> saveAttendant(@RequestBody BookPublisher publisher) {
        
        BookPublisher savedPublisher = repository.save(publisher);

        URI uri = ServletUriComponentsBuilder.
            fromCurrentRequest().
            path("/{id}").
            buildAndExpand(savedPublisher.getId()).
            toUri();
        
        return ResponseEntity.created(uri).body("Nome e id da nova Editora: " + 
            savedPublisher.getName() + " - " + savedPublisher.getId());
    }

    @PutMapping("/publishers/{id}")
    public ResponseEntity<?> updateAttendant(@RequestBody BookPublisher publisher, @PathVariable int id) {

        Optional<BookPublisher> publisherFound = repository.findById(id);

        if (!publisherFound.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        publisher.setId(id);
        repository.save(publisher);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/publishers/{id}")
    public void deleteAttendant(@PathVariable int id) {
        
        Optional<BookPublisher> publisherFound = repository.findById(id);

        if (publisherFound.isPresent()) {
            repository.deleteById(id);
        }
    }
}