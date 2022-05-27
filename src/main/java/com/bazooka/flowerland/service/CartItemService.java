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

    public List<Product> retrieveProductsFromCart() {
        List<CartItem> cartItems  =cartItemRepository.findAll();
        List<Product> productsInCart = new ArrayList<>();

        for (CartItem item : cartItems) {
            productsInCart.add(item.getProduct());
        }
        
        return productsInCart;
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public Integer getTotalCartCost() {
        int total = 0;
        int n = getCartItems().size();
        List<Integer> prices = getCartItems().stream().map(c -> c.getProduct().getPrice()).toList();
        List<Integer> quantities = getCartItems().stream().map(CartItem::getQuantity).toList();

        for (int i = 0; i < n; i++) {
            total += prices.get(i) * quantities.get(i);
        }

        return total;
    }

    public void deleteItemFromCart(CartItem item) {
        cartItemRepository.deleteById(item.getId());
    }

    public void addItemToCart(Product product) {
        cartItemRepository.save(new CartItem(product, 1));
    }

    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }
}