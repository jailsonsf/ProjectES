package com.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @ManyToOne(optional = true)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(optional = true)
    @JoinColumn(name = "bookpublisher_id")
    private BookPublisher bookPublisher;

    public Book() {
    }

    public Book(String title, String description) {
        super();
        setTitle(title);
        setDescription(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

}