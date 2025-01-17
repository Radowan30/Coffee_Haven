package com.javaBrewers.coffeeHaven.controller;

import com.javaBrewers.coffeeHaven.model.Order;
import com.javaBrewers.coffeeHaven.model.User;
import com.javaBrewers.coffeeHaven.service.OrderService;
import com.javaBrewers.coffeeHaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String showOrdersList(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders_list";
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/api/{orderId}/status")
    @ResponseBody
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestBody Map<String, String> payload) {
        String newStatus = payload.get("status");
        return orderService.updateOrderStatus(orderId, newStatus);
    }

    @GetMapping("/api/user")
    @ResponseBody
    public List<Order> getOrdersForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get the logged-in username

        User user = userService.findByUsername(username); // Use the injected userService instance
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return orderService.getOrdersByUserId(user.getId());
    }

    @GetMapping("/my_orders")
    public String showUserOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get the logged-in username

        User user = userService.findByUsername(username); // Use the injected userService instance
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "my_orders";
    }
}