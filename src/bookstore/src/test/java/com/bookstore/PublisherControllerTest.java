package com.bookstore;

import com.bookstore.DefaultTests;
import com.bookstore.models.BookPublisher;

import org.junit.Test;
import org.springframework.http.*;

public class PublisherControllerTest extends DefaultTests {

    @Test
    public void CreatePublisher() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"uid\":100,\"name\":\"seuLivro\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/publishers"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }

    @Test
    public void BCreated() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"uid\":100,\"name\":\"josé\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/publishers"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }

    @Test
    public void GetB() throws Exception{
        BookPublisher bookPublisher = new BookPublisher("SeuLivro", "258631");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/publishers/1"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;

    }

    @Test
    public void GetBs() throws Exception{
        BookPublisher bookPublisher = new BookPublisher("SeuLivro", "258631");
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/publishers"), HttpMethod.GET,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    @Test
    public void testDeleteB() throws Exception{
        BookPublisher bookPublisher = new BookPublisher("SeuLivro", "258631");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/publishers"), HttpMethod.DELETE,entity,String.class);

        System.out.println(response.getStatusCodeValue());
        System.out.println(response);
        assert response.getStatusCodeValue() == 200;
    }
}