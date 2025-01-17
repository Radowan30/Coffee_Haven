package com.javaBrewers.coffeeHaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin";
    }

    @GetMapping("/user")
    public String userDashboard() {
        return "user";
    }
}
