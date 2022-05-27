package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.requests.DeleteItemRequest;
import com.bazooka.flowerland.service.CartItemService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartItemService cartItemService;
    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("cartItems", cartItemService.retrieveItemsFromCart());
        Integer totalCost = cartItemService.getTotalCartCost();
        model.addAttribute("totalCost", totalCost);
        model.addAttribute("deleteItemRequest", new DeleteItemRequest());
        return "cart/items";
    }

    @PostMapping("delete")
    public ModelAndView deleteItem(@ModelAttribute("cartItem") CartItem item) {
        ModelAndView mv = new ModelAndView("redirect:items");
        cartItemService.deleteItemFromCart(item);
        return mv;
    }

    @PostMapping("add")
    public ModelAndView addItem(@ModelAttribute("product") Product product) {
        ModelAndView mv = new ModelAndView("redirect:items");
        cartItemService.addItemToCart(product);
        return mv;
    }
}
