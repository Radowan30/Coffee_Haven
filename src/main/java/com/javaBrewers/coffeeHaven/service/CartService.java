package com.javaBrewers.coffeeHaven.service;

import com.javaBrewers.coffeeHaven.model.CartItem;
import com.javaBrewers.coffeeHaven.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    /**
     * Get all cart items.
     */
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    /**
     * Add a new item to the cart.
     */
    public CartItem addCartItem(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    /**
     * Update an existing cart item.
     */
    public CartItem updateCartItem(Long id, int quantity) {
        CartItem cartItem = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        cartItem.setQuantity(quantity);
        return cartRepository.save(cartItem);
    }

    /**
     * Remove an item from the cart.
     */
    public void removeCartItem(Long id) {
        cartRepository.deleteById(id);
    }
}
