package com.rameem.blogapi.controllers.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rameem.blogapi.model.UserModel;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainViewController {
    @GetMapping("/")
    public String home(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        return "index";
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
