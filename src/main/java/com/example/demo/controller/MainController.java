package com.example.demo.controller;

import com.example.demo.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/welcome")
    public String welcomePage(Model model, Authentication authentication) {
        // Add authenticated user's name to the model
        model.addAttribute("username", authentication.getName());
        return "welcome";
    }

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }

    @PostMapping("/feedback")
    @ResponseBody
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedbackForm) {
        System.out.println("Feedback received: " + feedbackForm.getMessage());
        return ResponseEntity.ok("Feedback submitted successfully!");
    }
}
