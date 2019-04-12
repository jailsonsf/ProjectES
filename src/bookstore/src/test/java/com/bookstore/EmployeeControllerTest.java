package com.bookstore;

import com.bookstore.DefaultTests;
import com.bookstore.models.Employee;

import org.junit.Test;
import org.springframework.http.*;

public class EmployeeControllerTest extends DefaultTests {

    @Test
    public void CreateEmployee() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"name\":\"josé\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/employees"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }

    @Test
    public void UserCreated() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"name\":\"josé\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/employees"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }

    @Test
    public void GetEmployee() throws Exception{
        Employee employee = new Employee("Claudio", 34);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/employees/1"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;

    }

    @Test
    public void GetUsers() throws Exception{
        Employee employee = new Employee("Elaine", 28);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/employees"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    @Test
    public void testDeleteUser() throws Exception{
        Employee employee = new Employee("Joana", 26);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/employees"), HttpMethod.DELETE,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        System.out.println(response);
        assert response.getStatusCodeValue() == 200;
    }
}