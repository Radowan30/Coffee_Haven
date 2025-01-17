package com.javaBrewers.coffeeHaven.controller;

import com.javaBrewers.coffeeHaven.model.CartItem;
import com.javaBrewers.coffeeHaven.model.Order;
import com.javaBrewers.coffeeHaven.model.Product;
import com.javaBrewers.coffeeHaven.model.User;
import com.javaBrewers.coffeeHaven.service.CartService;
import com.javaBrewers.coffeeHaven.service.OrderService;
import com.javaBrewers.coffeeHaven.service.ProductService;
import com.javaBrewers.coffeeHaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/show_cart")
    public String showCart(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        double subtotal = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
        double tax = subtotal * 0.10;
        double total = subtotal + tax;

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", total);

        return "shopping_cart";
    }

    @PostMapping("/add")
    @ResponseBody
    public CartItem addCartItem(@RequestParam Long productId, @RequestParam int quantity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        Product product = productService.getProductById(productId);
        CartItem cartItem = new CartItem();
        cartItem.setProductName(product.getName());
        cartItem.setPrice(product.getPrice());
        cartItem.setQuantity(quantity);
        cartItem.setUser(user);

        return cartService.addCartItem(cartItem);
    }

    @PostMapping("/placeOrder")
    @ResponseBody
    public Order placeOrder(@RequestParam Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        Product product = productService.getProductById(productId);
        Order order = new Order();
        order.setDate(new Date());
        order.setCustomer(username);
        order.setTotal(product.getPrice());
        order.setStatus("Pending");
        order.setUser(user);

        return orderService.addOrder(order);
    }

    @PostMapping("/cart/update")
    @ResponseBody
    public CartItem updateCartItem(@RequestParam Long id, @RequestParam int quantity) {
        return cartService.updateCartItem(id, quantity);
    }

    @DeleteMapping("/cart/{id}")
    @ResponseBody
    public void removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
    }
}
