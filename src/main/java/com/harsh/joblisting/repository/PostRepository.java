package com.harsh.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harsh.joblisting.models.Post;

public interface PostRepository extends MongoRepository<Post,String>{
    
    
}
