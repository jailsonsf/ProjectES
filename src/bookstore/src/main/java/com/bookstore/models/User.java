package com.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User extends Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public User(String name, int age) {
        super(name, age);
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}