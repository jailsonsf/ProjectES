package com.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String district;
    private int number;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address() {}

    public Address(String name, String district, int number) {
        super();
        setName(name);
        setDistrict(district);
        setNumber(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {

        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getName() {
        return name;
    }
}