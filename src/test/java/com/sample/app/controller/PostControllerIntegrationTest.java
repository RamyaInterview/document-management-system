/*
 * package com.sample.app.controller; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.sample.app.dto.PostRequest;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * import static org.hamcrest.Matchers.*;
 * 
 * @SpringBootTest
 * 
 * @AutoConfigureMockMvc public class PostControllerIntegrationTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @Test public void testGetPost() throws Exception {
 * mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.content().contentType(MediaType.
 * APPLICATION_JSON)) .andExpect(MockMvcResultMatchers.jsonPath("$.title",
 * is("foo"))) .andExpect(MockMvcResultMatchers.jsonPath("$.body", is("bar")))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.userId", is(1))); }
 * 
 * @Test public void testCreatePost() throws Exception { PostRequest postRequest
 * = new PostRequest("foo", "bar", 1);
 * 
 * mockMvc.perform(MockMvcRequestBuilders.post("/posts")
 * .contentType(MediaType.APPLICATION_JSON) .content(new
 * ObjectMapper().writeValueAsString(postRequest)))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.content().contentType(MediaType.
 * APPLICATION_JSON)) .andExpect(MockMvcResultMatchers.jsonPath("$.id",
 * is(notNullValue()))) .andExpect(MockMvcResultMatchers.jsonPath("$.title",
 * is("foo"))) .andExpect(MockMvcResultMatchers.jsonPath("$.body", is("bar")))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.userId", is(1))); } }
 */