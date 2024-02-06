package com.myblog.myblog18.controller;

import com.myblog.myblog18.Service.PostService;
import com.myblog.myblog18.payload.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//      http://localhost:8080/api/post
@RestController
@RequestMapping("/api/post")
public class PostController {
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping
    public ResponseEntity<PostDto> createRegistration(@RequestBody PostDto postDto){
        PostDto dto = postService.createRegistration(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
