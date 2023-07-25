package com.sample.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.dto.PostRequest;
import com.sample.app.service.JsonPlaceholderClient;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final JsonPlaceholderClient jsonPlaceholderClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public PostController(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest) {
    	LOGGER.info("I am running create post service for " +postRequest.getUserId());
        return jsonPlaceholderClient.createPost(postRequest);
    }
    
    @GetMapping("/{postId}")
    public ResponseEntity<String> getPost(@PathVariable Long postId) {
    	LOGGER.info("I am getting post details for document"+postId);
    	LOGGER.debug("I am at get post");
        return jsonPlaceholderClient.getPost(postId);
    }
    
	
}
