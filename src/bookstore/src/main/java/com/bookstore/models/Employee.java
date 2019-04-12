package com.bookstore.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("employee")
public class Employee extends Person {

    public Employee() {}
    
    public Employee(String name, int age) {
        super(name, age);
    }

    public void setId (Integer id) {
        super.setId(id);
    }

    public Integer getId() {
        return super.getId();
    }
}