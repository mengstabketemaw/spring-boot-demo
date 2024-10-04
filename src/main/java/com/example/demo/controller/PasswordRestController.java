package com.example.demo.controller;

import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class PasswordRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "reset-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = UUID.randomUUID().toString(); // Generate token
        userService.createPasswordResetTokenForUser(email, token);

        // Send email with token link
        String resetPasswordUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + "/reset-password?token=" + token;
        // Use a mail service to send the email

        model.addAttribute("message", "A reset password link has been sent to " + email);
        return "forgot-password";
    }

    @GetMapping("/reset-password")
    public String showResetPasswordPage(@RequestParam("token") String token, Model model) {
        if (userService.isValidPasswordResetToken(token)) {
            model.addAttribute("token", token);
            return "reset-password";
        } else {
            model.addAttribute("message", "Invalid or expired token");
            return "error";
        }
    }

    @PostMapping("/reset-password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String newPassword = request.getParameter("password");

        if (userService.isValidPasswordResetToken(token)) {
            userService.updatePassword(token, newPassword);
            return "redirect:/login?resetSuccess";
        } else {
            model.addAttribute("message", "Invalid token");
            return "error";
        }
    }
}
