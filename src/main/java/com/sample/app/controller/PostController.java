package com.sample.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.app.dto.PostRequest;
import com.sample.app.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PostService postService;

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest) throws JsonProcessingException {
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String body = postRequest.toJsonString();

		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				String.class);
		return responseEntity;
	}

	@GetMapping("/{postId}")
	public ResponseEntity<String> getPost(@PathVariable Long postId) {
		return postService.getPost(postId);
	}

}
