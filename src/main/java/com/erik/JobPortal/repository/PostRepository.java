package com.erik.JobPortal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erik.JobPortal.models.PostModel;

public interface PostRepository extends MongoRepository<PostModel, String>{

}
