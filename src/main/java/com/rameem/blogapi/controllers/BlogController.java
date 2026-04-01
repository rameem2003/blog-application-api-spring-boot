package com.rameem.blogapi.controllers;

import com.rameem.blogapi.model.BlogModel;
import com.rameem.blogapi.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    public BlogRepository blogRepository;

    @GetMapping("/all")
    public List<BlogModel> allBlogs(){
        return blogRepository.findAll();
    }

    @PostMapping("/create")
    public String createBlog(@RequestBody BlogModel newBLog){
        blogRepository.save(newBLog);
        return "A Blog is Created";
    }

    @PutMapping("/update/{id}")
    public String updateBlog(@PathVariable Long id, @RequestBody BlogModel newBlog ){
 List<BlogModel> allBlogs = blogRepository.findAll();

     for(BlogModel blog : allBlogs){
         if(blog.getId().equals(id)){
             blog.setTitle(newBlog.getTitle());
             blog.setContent(newBlog.getContent());

             blogRepository.save(blog);

             break;

         }else {
             return "Blog not found";

         }
     }

        return "A Blog is Updated";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id){
        blogRepository.deleteById(id);
        return "Id " + id + " has been deleted";

    }
}
