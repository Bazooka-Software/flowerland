package com.bazooka.flowerland.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    public class Flower {
        String name;
        String price;
        String quantity;
        String imageUrl;

        public Flower(String name, String price, String quantity, String imageUrl) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getImageUrl() {
            return imageUrl;
        }

    }

    @GetMapping({
            "/",
            "/index"
    })
    public String hello(@RequestParam(value = "name", defaultValue = "World",
            required = true) String name, Model model) {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Flower("Hortenzija", "3.5", "21", "img_1.png"));
        flowers.add(new Flower("Tulpe", "4.25", "5", "img_2.png"));
        flowers.add(new Flower("Gvazdikas", "3.75", "9", "img_3.png"));
        flowers.add(new Flower("Rozmarinas", "5.00", "15", "img_4.png"));

        model.addAttribute("flowers", flowers);
        return "index";
    }
}
