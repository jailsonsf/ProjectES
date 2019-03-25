package com.bookstore.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("author")
public class Author extends Person {

    private String nationaly;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books;

    public Author(String name, int age, String nationaly) {
        super(name, age);
        setNationaly(nationaly);
    }

    public void setId (Integer id) {
        super.setId(id);;
    }

    public void setNationaly(String nationaly) {
        this.nationaly = nationaly;
    }

    public String getNationaly() {
        return nationaly;
    }

    public Integer getId() {
        return super.getId();
    }
}