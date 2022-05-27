package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.model.Cart;
import com.bazooka.flowerland.requests.DeleteItemRequest;
import com.bazooka.flowerland.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartItemService cartItemService;
    @GetMapping("/items")
    public CompletableFuture<String> items(Model model) throws ExecutionException, InterruptedException {
        List<Product> productsInCart = CompletableFuture.supplyAsync(() -> cartItemService.retrieveProductsFromCart()).get();
        List<CartItem> cartItems = CompletableFuture.supplyAsync(() -> cartItemService.getCartItems()).get();
        Cart cart = new Cart(cartItems);
        model.addAttribute("cart", cart);
        model.addAttribute("cartItemsInCart", cartItems);
        Integer totalCost = cartItemService.getTotalCartCost();
        model.addAttribute("totalCost", totalCost);
        model.addAttribute("deleteItemRequest", new DeleteItemRequest());
        return CompletableFuture.supplyAsync(() -> "cart/items");
    }

    @PostMapping("delete")
    public CompletableFuture<ModelAndView> deleteItem(@ModelAttribute("cartItem") CartItem item) {
        ModelAndView mv = new ModelAndView("redirect:items");
        cartItemService.deleteItemFromCart(item);
        return CompletableFuture.supplyAsync(() -> mv);
    }

    @PostMapping("add")
    public CompletableFuture<ModelAndView> addItem(@ModelAttribute("cartItem") CartItem cartItem) {
        ModelAndView mv = new ModelAndView("redirect:items");
        var items = cartItemService.getCardItemsByProduct(cartItem.getProduct());

        if (items.isEmpty()) {
            cartItemService.addCartItem(cartItem);
        } else {
            var previousItem = items.get(0);
            var currentQuantity = previousItem.getQuantity();
            previousItem.setQuantity(currentQuantity + cartItem.getQuantity());

            cartItemService.addCartItem(previousItem);
        }
        return CompletableFuture.supplyAsync(() -> mv);
    }

    @PostMapping("checkout")
    public ModelAndView checkout(@ModelAttribute("cart") Cart cart) {
        ModelAndView mv = new ModelAndView("checkout");
        mv.addObject("cart", cart);
        return mv;
    }
}
