package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartItemService cartItemService;
    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("cartItems", cartItemService.retrieveItemsFromCart());
        model.addAttribute("totalCost", cartItemService.getTotalCartCost());
        return "cart/items";
    }
}
