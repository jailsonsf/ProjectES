package com.bookstore;

import com.bookstore.DefaultTests;
import com.bookstore.models.Book;

import org.junit.Test;
import org.springframework.http.*;

public class BookControllerTest extends DefaultTests {

    @Test
    public void CreateBook() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"name\":\"adventures\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/books"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }

    @Test
    public void BookCreated() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"name\":\"adventures\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/books"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }

    @Test
    public void GetBook() throws Exception{
        Book book = new Book("Adventures", "A Continuaçao");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/books/1"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;

    }

    @Test
    public void GetBooks() throws Exception{
        Book book = new Book("Adventures", "A Continuaçao");
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/books"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    @Test
    public void testDeleteBook() throws Exception{
        Book book = new Book("Adventures", "A Continuaçao");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/books"), HttpMethod.DELETE,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        System.out.println(response);
        assert response.getStatusCodeValue() == 200;
    }
}