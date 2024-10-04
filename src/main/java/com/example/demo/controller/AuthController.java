package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(Model model) {
        return "login"; // Return the login view
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup"; // Return the signup view
    }

    @PostMapping("/signup")
    public String signupSubmit(/* parameters for signup */) {
        return "redirect:/login";
    }
}
