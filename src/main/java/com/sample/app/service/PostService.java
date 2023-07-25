package com.sample.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/*
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;*/

@Service
public class PostService {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/";

    @Autowired
    private RestTemplate restTemplate;

   // @CircuitBreaker(name = "getPosts", fallbackMethod = "getPostsFallback")
   // @RateLimiter(name = "getPosts") 
   // @Retry(name = "getPosts")
    public ResponseEntity<String> getPost(Long postId) {
        String url = BASE_URL + postId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity;
    }

    public ResponseEntity<String> getPostsFallback(Long postId, Exception ex) {
        // Fallback logic to handle the failure
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve post. Please try again later.");
    }
}
