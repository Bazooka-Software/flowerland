package com.bazooka.flowerland.service;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.repository.CartItemRepository;
import com.bazooka.flowerland.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.ArrayList;
import java.util.List;

@Service
@RequestScope
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;



    public List<Product> retrieveProductsFromCart() {
        List<Product> productsInCart = new ArrayList<>();
        String sesId = RequestContextHolder.currentRequestAttributes().getSessionId();
        List<CartItem> cartItems  = cartItemRepository.findAllBySessionId(sesId);

        for (CartItem item : cartItems) {
            productsInCart.add(item.getProduct());
        }
        
        return productsInCart;
    }

    public List<CartItem> getCartItems() {
        String sesId = RequestContextHolder.currentRequestAttributes().getSessionId();
        return cartItemRepository.findAllBySessionId(sesId);
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


    public void addItemToCart(Product product, String sessionId) {
        cartItemRepository.save(new CartItem(product, sessionId,1));
    }

    public List<CartItem> getCardItemsByProductAndSessionId(Product product, String sessionId) { return cartItemRepository.findAllByProductAndSessionId(product, sessionId); }

    public void addCartItem(CartItem cartItem) { cartItemRepository.save(cartItem);}
}