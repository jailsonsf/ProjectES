package com.bookstore.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Author extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nationaly;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books;

    public Author(String name, int age, String nationaly) {
        super(name, age);
        setNationaly(nationaly);
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public void setNationaly(String nationaly) {
        this.nationaly = nationaly;
    }

    public String getNationaly() {
        return nationaly;
    }

    public Integer getId() {
        return id;
    }
}