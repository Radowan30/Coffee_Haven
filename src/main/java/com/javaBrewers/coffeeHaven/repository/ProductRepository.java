package com.javaBrewers.coffeeHaven.repository;

import com.javaBrewers.coffeeHaven.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    // Method to search products by name, type, or origin
    List<Product> findByNameContainingOrTypeContainingOrOriginContaining(String name, String type, String origin);

    // Methods to sort products by price or type
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByTypeAsc();
    List<Product> findAllByOrderByTypeDesc();

}
