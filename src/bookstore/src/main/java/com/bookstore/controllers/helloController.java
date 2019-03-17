package com.bookstore.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class helloController {
    @RequestMapping("/")
    public String index() {
        return "Hello world Spring Boot!";
    }
}