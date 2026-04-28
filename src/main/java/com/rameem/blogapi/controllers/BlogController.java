package com.rameem.blogapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rameem.blogapi.model.BlogModel;
import com.rameem.blogapi.model.UserModel;
import com.rameem.blogapi.services.BlogServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private BlogServices blogServices;


    @GetMapping("/")
    public String index(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/api/blog/all")
    public List<BlogModel> getAllBlogsController(@RequestParam String param) {
        return blogServices.getAllBlogs();
    }

    @PostMapping("/api/blog/add")
    public String addNewBlogController(@RequestBody BlogModel newBLog, HttpSession session) {

        UserModel user = (UserModel) session.getAttribute("user");

        if (user == null) {
            return "Please login to add a blog";
        }
        newBLog.setUser(user);

        blogServices.saveBlog(newBLog);
        return "Blog added successfully";

    }

}
