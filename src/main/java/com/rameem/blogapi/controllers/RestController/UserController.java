package com.rameem.blogapi.controllers.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/api/auth/register")
    public String register(@RequestBody UserModel user) {

        userServices.createUser(user);

        return "User Registered Successfully";

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
}
