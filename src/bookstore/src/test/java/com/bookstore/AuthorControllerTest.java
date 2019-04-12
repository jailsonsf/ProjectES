package com.bookstore;

import com.bookstore.DefaultTests;
import com.bookstore.models.Author;

import org.junit.Test;
import org.springframework.http.*;

public class AuthorControllerTest extends DefaultTests {

    @Test
    public void CreateAuthor() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"name\":\"josé\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/authors"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }

    @Test
    public void AuthorCreated() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"name\":\"josé\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/authors"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }

    @Test
    public void GetAuthor() throws Exception{
        Author author = new Author("Claudio", 34, "Brasileiro");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/authors/1"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;

    }

    @Test
    public void GetAuthors() throws Exception{
        Author author = new Author("Elaine", 28, "Brasileira");
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/authors"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    @Test
    public void testDeleteAuthor() throws Exception{
        Author author = new Author("Joana", 26, "Brasileira");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/authors"), HttpMethod.DELETE,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        System.out.println(response);
        assert response.getStatusCodeValue() == 200;
    }
}