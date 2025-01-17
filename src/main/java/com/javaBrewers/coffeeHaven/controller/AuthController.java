package com.javaBrewers.coffeeHaven.controller;

import java.util.List;

import com.javaBrewers.coffeeHaven.model.Role;
import com.javaBrewers.coffeeHaven.model.User;
import com.javaBrewers.coffeeHaven.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        List<Role> roles = userService.getAllRoles(); // Fetch all roles dynamically
        model.addAttribute("user", user);
        model.addAttribute("roles", roles); // Pass roles to the view
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, String roleName, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username is already taken");
            return "register";
        }
        userService.registerUser(user, roleName);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
