package com.harsh.joblisting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.joblisting.models.Post;
import com.harsh.joblisting.repository.PostRepository;
import com.harsh.joblisting.repository.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;


@RestController
public class PostController{
 //spring will create an object auto map it
   @Autowired
   PostRepository repo;

   @Autowired
   SearchRepository srepo;


   @ApiIgnore //used to ignore all other info of swagger api
   @RequestMapping(value = "/")
   public void redirect(HttpServletResponse response) throws IOException
   {
response.sendRedirect("/swagger-ui.html");
   }

   @GetMapping("/posts") //to get data from server
   public List<Post> getAllPosts()
{
return repo.findAll();
}
//Pathvariable text would be used as posts/text
@GetMapping("/posts/{text}")
public List<Post>  search(@PathVariable String text)
{
   return srepo.findByText(text);
}
   
@PostMapping("/post") //to post data to server
public Post addPost(@RequestBody Post post)
{
return repo.save(post);
}



}