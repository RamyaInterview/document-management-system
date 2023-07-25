/**
 * 
 */
package com.sample.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sample.app.dto.PostRequest;

import io.github.resilience4j.retry.annotation.Retry;

/**
 * Fiegn client added here
 */
@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {
    @HystrixCommand(fallbackMethod = "createPostFallback")
	 @PostMapping(value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    ResponseEntity<String> createPost(@RequestBody PostRequest postRequest);
	 
    @Retry(name = "jsonplaceholder", fallbackMethod = "getPostFallback")
	  @GetMapping("/posts/{postId}")
	    ResponseEntity<String> getPost(@PathVariable Long postId);

	  default ResponseEntity<String> createPostFallback(PostRequest postRequest, Exception ex) {
	        // Fallback logic to handle the failure
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create post. Please try again later.");
	    }
	  
}
