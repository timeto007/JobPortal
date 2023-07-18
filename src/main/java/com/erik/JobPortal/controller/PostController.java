package com.erik.JobPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erik.JobPortal.models.PostModel;
import com.erik.JobPortal.repository.PostRepository;
import com.erik.JobPortal.repository.SearchRepository;

@RestController
public class PostController {
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	SearchRepository searchRepo;
	
    @GetMapping("/allPosts")
    public List<PostModel> getAllPosts()
    {
        return postRepo.findAll();
    }
    
    
    @PostMapping("/postJob")
    public PostModel postJob(@RequestBody PostModel post) {
    	return postRepo.save(post);
    }
    
    
    
    @GetMapping("/search/{text}")
    public List<PostModel>searchJob(@PathVariable String text) {
		return searchRepo.findByText(text);
    	
    }
    
}
