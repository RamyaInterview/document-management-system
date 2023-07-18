package com.sample.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.app.dto.Comment;
import com.sample.app.dto.CommentRequest;
import com.sample.app.service.CommentService;

@RestController
@RequestMapping("/posts")
public class CommentController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

	/*
	 * @PostMapping("/{postId}/")
	 * 
	 * @ResponseBody public ResponseEntity<String> createPost(@RequestBody
	 * CommentRequest postRequest) throws JsonProcessingException { String url =
	 * "https://jsonplaceholder.typicode.com/posts/"; HttpHeaders headers = new
	 * HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON);
	 * 
	 * String body = postRequest.toJsonString();
	 * 
	 * HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
	 * ResponseEntity<String> responseEntity = restTemplate.exchange(url,
	 * HttpMethod.POST, requestEntity, String.class); return responseEntity; }
	 */
    
    @GetMapping("/{postId}/comments")
	public ResponseEntity<String> getComments(@PathVariable Long postId) {
		return commentService.createComment(postId);
	}

    
    

}


