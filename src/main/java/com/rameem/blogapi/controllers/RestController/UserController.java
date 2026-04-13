package com.rameem.blogapi.controllers.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rameem.blogapi.model.UserModel;
import com.rameem.blogapi.services.UserServices;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public String register(@RequestBody UserModel user) {

        userServices.createUser(user);

        return "User Registered Successfully";

    }

    @PostMapping("/login")
    public String login(@RequestBody UserModel user, HttpSession session) {
        UserModel loggedInUser = userServices.loginUser(user.getEmail(), user.getPassword());

        if (loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            return "Login Successful";
        } else {
            return "Invalid email or password";
        }
    }
}
