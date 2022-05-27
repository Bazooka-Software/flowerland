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

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartItemService cartItemService;
    @GetMapping("/items")
    public String items(Model model) {
        List<Product> productsInCart = cartItemService.retrieveProductsFromCart();
        List<CartItem> cartItems = cartItemService.getCartItems();
        Cart cart = new Cart(cartItems);
        model.addAttribute("cart", cart);
        model.addAttribute("productsInCart", productsInCart);
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
    public ModelAndView addItem(@ModelAttribute("cartItem") CartItem cartItem) {
        ModelAndView mv = new ModelAndView("redirect:items");
        var items = cartItemService.getCardItemsByProduct(cartItem.getProduct());

        if (items.isEmpty()) {
            cartItemService.addCartItem(cartItem);
        } else {
            var currentQuantity = items.get(0).getQuantity();
            items.get(0).setQuantity(currentQuantity + cartItem.getQuantity());
        }
        return mv;
    }

    @PostMapping("checkout")
    public ModelAndView checkout(@ModelAttribute("cart") Cart cart) {
        ModelAndView mv = new ModelAndView("checkout");
        mv.addObject("cart", cart);
        return mv;
    }
}
