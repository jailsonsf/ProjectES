package com.bookstore;

import com.bookstore.DefaultTests;
import com.bookstore.models.User;

import org.junit.Test;
import org.springframework.http.*;

public class UserControllerTest extends DefaultTests {

    @Test
    public void CreateUser() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"uid\":100,\"name\":\"josé\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/users"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }

    @Test
    public void UserCreated() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"uid\":100,\"name\":\"josé\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }

    @Test
    public void GetUser() throws Exception{
        User user = new User("Claudio", 34);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users/1"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;

    }

    @Test
    public void GetUsers() throws Exception{
        User user = new User("Elaine", 28);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    @Test
    public void testDeleteUser() throws Exception{
        User user = new User("Joana", 26);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"), HttpMethod.DELETE,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        System.out.println(response);
        assert response.getStatusCodeValue() == 200;
    }
}