package com.bazooka.flowerland.service;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.repository.CartItemRepository;
import com.bazooka.flowerland.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveItemsFromCart() {
        List<CartItem> cartItems = new ArrayList<>();
        List<Product> productsInCart = new ArrayList<>();
        cartItemRepository.findAll().forEach(c -> cartItems.add(c));

        for (CartItem item : cartItems) {
            productsInCart.add(item.getProduct());
        }
        
        return productsInCart;
    }

    public Integer getTotalCartCost() {
        return retrieveItemsFromCart().stream().mapToInt(Product::getPrice).sum();
    }

    public void deleteItemFromCart(CartItem item) {
        cartItemRepository.deleteById(item.getId());
    }

    public void addItemToCart(Product product) {
        cartItemRepository.save(new CartItem(product));
    }
}
