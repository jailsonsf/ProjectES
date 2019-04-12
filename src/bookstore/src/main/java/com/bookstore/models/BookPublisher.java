package com.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookPublisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String cnpj;

    public BookPublisher() {

    }

    public BookPublisher(String name, String cnpj) {
        super();
        setName(name);
        setCnpj(cnpj);
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }
}