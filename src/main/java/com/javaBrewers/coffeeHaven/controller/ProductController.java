package com.javaBrewers.coffeeHaven.controller;

import com.javaBrewers.coffeeHaven.model.Product;
import com.javaBrewers.coffeeHaven.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

//    @RequestMapping("/{name}")
//    public Product getProductByName(@PathVariable String name) {
//        System.out.println("Fetching product details for name: " + name); // Debug log
//        Product product = productService.findByName(name);
//        if (product == null) {
//            System.out.println("No product found for name: " + name); // Debug log
//        }
//        return product;
//    }

    // New API endpoint to search products by name, type, or origin
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("query") String query) {
        return productService.searchByNameTypeOrOrigin(query);
    }

    // New API endpoint to sort products by price or type
    @GetMapping("/sort")
    public List<Product> sortProducts(
            @RequestParam("sortBy") String sortBy,
            @RequestParam(value = "order", defaultValue = "asc") String order) {
        return productService.sortBy(sortBy, order);
    }

    // New endpoint to fetch product details for the product modal
    @GetMapping("/{name}/details")
    public Product getProductDetails(@PathVariable String name) {
        return productService.findByName(name);
    }

    // Renamed the method for the /catalogue endpoint to avoid conflict
    @GetMapping("/catalogue")
    public List<Product> getAllProductsForCatalogue() {
        return productService.findAllProducts();  // Ensure this method exists in ProductService
    }

}
