package com.bookstore.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("user")
public class User extends Person {

    public User() {}

    public User(String name, int age) {
        super(name, age);
    }

    public void setId (Integer id) {
        super.setId(id);
    }

    public Integer getId() {
        return super.getId();
    }
}