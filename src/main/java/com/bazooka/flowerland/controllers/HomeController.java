package com.bazooka.flowerland.controllers;


import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({
            "/",
            "/index"
    })
    public String hello(@RequestParam(value = "name", defaultValue = "Customer",
            required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
