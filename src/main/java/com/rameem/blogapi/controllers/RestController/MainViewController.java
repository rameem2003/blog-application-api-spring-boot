package com.rameem.blogapi.controllers.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rameem.blogapi.model.BlogModel;
import com.rameem.blogapi.model.UserModel;
import com.rameem.blogapi.services.BlogServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainViewController {
    @Autowired
    private BlogServices blogServices;

    @GetMapping("/")
    public String home(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String getBlog(@PathVariable Long id, Model model) {
        BlogModel blog = blogServices.getBlogById(id);

        if (blog == null) {
            return "redirect:/";
        }
        model.addAttribute("blog", blog);

        return "blog-detail";
    }

    @GetMapping("/add-blog")
    public String addNewBlogPage(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "add-blog";
    }

}
