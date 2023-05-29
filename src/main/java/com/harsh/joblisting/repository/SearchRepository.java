package com.harsh.joblisting.repository;

import java.util.List;

import com.harsh.joblisting.models.Post;

public interface SearchRepository {
  
  List<Post> findByText(String text);


}
