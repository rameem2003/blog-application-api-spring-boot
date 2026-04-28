package com.rameem.blogapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rameem.blogapi.model.UserModel;
import com.rameem.blogapi.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserServices userServices;


    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if(user != null){
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/api/auth/register")
    public String register(@RequestBody UserModel user, Model model) {

        UserModel data = userServices.createUser(user);

        System.out.println(data);
        if (data.getId() != null) {
            return "redirect:/login";
        }
        model.addAttribute("error", "Something went wrong");
        return "redirect:/register";


    }

    @PostMapping("/api/auth/login")
    public String login( UserModel user, HttpSession session, Model model) {
        UserModel loggedInUser = userServices.loginUser(user.getEmail(), user.getPassword());

        System.out.println(loggedInUser);
        if (loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @PostMapping("/api/auth/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
