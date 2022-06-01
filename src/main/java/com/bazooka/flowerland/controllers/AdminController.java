package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserOrderService userOrderService;

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("userOrders", userOrderService.getAllOrders());
        return "user_orders";
    }
}
