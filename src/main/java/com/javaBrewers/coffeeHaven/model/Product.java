package com.javaBrewers.coffeeHaven.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaBrewers.coffeeHaven.repository.ProductRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String origin;
    private Double price;
    private Integer stock;
    private String imageURL;


    // New field for product type
    private String type;

    // New method to check stock availability
    public boolean isInStock() {
        return stock != null && stock > 0;
    }

    // New method to apply a discount to the product price
    public void applyDiscount(Double percentage) {
        if (price != null && percentage != null && percentage > 0) {
            this.price = this.price - (this.price * percentage / 100);
        }
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImage() {
        return imageURL;
    }

    public void setImage(String image) {
        this.imageURL = image;
    }
}
