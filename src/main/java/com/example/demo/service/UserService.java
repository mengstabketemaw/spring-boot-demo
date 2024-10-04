package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender; // For sending emails

    // Display the forgot password page
    @GetMapping("/forgot-password")
    public ModelAndView showForgotPasswordPage() {
        return new ModelAndView("forgot-password");
    }

    // Handle the forgot password form submission
    @PostMapping("/forgot-password")
    public String handleForgotPassword(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "Email not found"; // You may want to handle this more gracefully
        }

        // Generate a reset token and expiration time
        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        user.setTokenExpiry(LocalDateTime.now().plusHours(1)); // Token valid for 1 hour
        userRepository.save(user);

        // Send email with reset link
        String resetLink = "http://localhost:8080/reset-password?token=" + token;
        sendResetEmail(user.getEmail(), resetLink);

        return "Reset link sent to your email"; // Provide user feedback
    }

    private void sendResetEmail(String to, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Password Reset Request");
        message.setText("Click the link to reset your password: " + resetLink);
        mailSender.send(message);
    }

    // Display the reset password page
    @GetMapping("/reset-password")
    public ModelAndView showResetPasswordPage(@RequestParam String token) {
        return new ModelAndView("reset-password").addObject("token", token);
    }

    // Handle password reset form submission
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        User user = userRepository.findByResetToken(token);

        if (user == null || user.getTokenExpiry().isBefore(LocalDateTime.now())) {
            return "Invalid or expired token"; // Handle invalid token scenario
        }

        // Update the user's password
        user.setPassword(newPassword); // Ideally, you should hash the password here
        user.setResetToken(null); // Clear the reset token
        user.setTokenExpiry(null); // Clear the expiry
        userRepository.save(user);

        return "Password successfully reset"; // Provide user feedback
    }
}
