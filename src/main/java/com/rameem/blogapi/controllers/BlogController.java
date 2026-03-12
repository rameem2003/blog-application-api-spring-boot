package com.rameem.blogapi.controllers;

import com.rameem.blogapi.model.BlogModel;
import com.rameem.blogapi.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
