package com.javaBrewers.coffeeHaven.repository;

import com.javaBrewers.coffeeHaven.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
}
