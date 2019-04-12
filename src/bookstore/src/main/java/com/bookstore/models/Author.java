package com.bookstore.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("author")
public class Author extends Person {

    private String nationaly;

    public Author() {}

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