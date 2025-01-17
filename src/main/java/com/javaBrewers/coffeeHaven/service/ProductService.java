package com.javaBrewers.coffeeHaven.service;

import com.javaBrewers.coffeeHaven.model.Product;
import com.javaBrewers.coffeeHaven.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Method to find a product by its name
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    // Method to fetch all products (for /api/products)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Method to search products by name, type, or origin
    public List<Product> searchByNameTypeOrOrigin(String query) {
        return productRepository.findByNameContainingOrTypeContainingOrOriginContaining(query, query, query);
    }

    // Method to sort products by price or type
    public List<Product> sortBy(String sortBy, String order) {
        if (sortBy.equals("price")) {
            return order.equals("asc") ? productRepository.findAllByOrderByPriceAsc() : productRepository.findAllByOrderByPriceDesc();
        } else if (sortBy.equals("type")) {
            return order.equals("asc") ? productRepository.findAllByOrderByTypeAsc() : productRepository.findAllByOrderByTypeDesc();
        }
        return productRepository.findAll(); // Default if no valid sortBy is given
    }

    // Method to fetch all products (for /catalogue)
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
