package com.javaBrewers.coffeeHaven.controller;

import com.javaBrewers.coffeeHaven.model.Product;
import com.javaBrewers.coffeeHaven.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsController {

    @Autowired
    private ProductService productService;

    // API endpoint to fetch product details by name
    @RequestMapping("/productdetails/{name}")
    public Product getProductByName(@PathVariable String name) {
        System.out.println("Fetching product details for name: " + name); // Debug log
        Product product = productService.findByName(name);
        if (product == null) {
            System.out.println("No product found for name: " + name); // Debug log
        }
        return product;
    }

}
