package com.rameem.blogapi.controllers.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rameem.blogapi.model.UserModel;
import com.rameem.blogapi.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/login")
    public String getLogin(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if (user != null) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        if (user != null) {
            return "redirect:/";
        }
        return "register";
    }

    @GetMapping("/profile")
    public String profilePage(HttpSession session, Model model) {
        UserModel user = (UserModel) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/api/auth/register")
    public String register(UserModel user, Model model) {

        UserModel createdUser = userServices.createUser(user);

        if (createdUser != null) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "registration";
        }

    }

    @PostMapping("/api/auth/login")
    public String login(UserModel user, HttpSession session, Model model) {
        UserModel loggedInUser = userServices.loginUser(user.getEmail(), user.getPassword());

        if (loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }
    }

    @PostMapping("/api/auth/logout")
    public String logout(HttpSession session) {
        // TODO: process POST request

        session.invalidate();
        return "redirect:/";
    }

}
