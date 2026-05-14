package com.rameem.blogapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "index";
    }

    @GetMapping("/new-blog")
    public String newBlog(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "newBlog";
    }

    @GetMapping("/blog/{id}")
    public String singleBlog(@PathVariable Long id, Model model) {
        System.err.println(id);
        // fetch the blog by id and add it to the model
        BlogModel blog = blogServices.getBlogById(id);

        model.addAttribute("blog", blog);
        return "blog-page";
    }

    @GetMapping("/api/blog/all")
    @ResponseBody
    public List<BlogModel> getAllBlogsController() {
        return blogServices.getAllBlogs();
    }

    @GetMapping("/api/blog/user")
    @ResponseBody
    public List<BlogModel> getBlogsByUserIdController(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if (user == null) {
            return null;
        }
        return blogServices.getBlogsByUserId(user.getId());
    }

    @PostMapping("/api/blog/add")
    public String addNewBlogController(BlogModel newBLog, HttpSession session) {

        UserModel user = (UserModel) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }
        newBLog.setUser(user);

        blogServices.saveBlog(newBLog);
        return "redirect:/";

    }

    @PutMapping("/api/blog/update/{id}")
    @ResponseBody
    public BlogModel updateBlog(@PathVariable Long id, @RequestBody BlogModel blog) {

        return blogServices.updateBlog(id, blog);
    }

}
