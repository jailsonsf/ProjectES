package com.bookstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("employee")
public class Employee extends Person {

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Address> addresses;

    public Employee() {}
    
    public Employee(String name, int age, Address address) {
        super(name, age);
        this.addresses = new ArrayList<Address>();
    }

    public void setId (Integer id) {
        super.setId(id);
    }

    public void setAddresses(List<Address> address) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Integer getId() {
        return super.getId();
    }
}