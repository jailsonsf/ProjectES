package com.bookstore.repository;

import com.bookstore.models.BookPublisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<BookPublisher, Integer> {
    
}