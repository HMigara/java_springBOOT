package com.example.democart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.democart.model.User;
import com.example.democart.service.UserService;

    @Controller
    public class LoginController {

        @Autowired
        private UserService userService;

        @GetMapping("/")
        public String showLoginPage() {
            return "login";
        }

        @PostMapping("/login")
        public String login(@RequestParam String username, @RequestParam String password, Model model) {

            User user = userService.findByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                System.out.println("login complete");
                return "redirect:/pizzas";
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        }
    }

