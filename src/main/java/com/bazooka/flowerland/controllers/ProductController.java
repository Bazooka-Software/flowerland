package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.model.Cart;
import com.bazooka.flowerland.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping({
            "/products"
    })
    public String hello(@RequestParam(value = "name", defaultValue = "World",
            required = true) String name, Model model) {
        List<Product> flowers = productService.retrieveProducts();

        model.addAttribute("flowers", flowers);
        return "products";
    }
  /*  @GetMapping({"/all"})
    public String getAllProducts() {

        return "products";
    }*/
  @GetMapping({
          "/singleProduct"
  })
  public String singleProduct(
          @RequestParam(value = "name", defaultValue = "Customer", required = true) String name,
          @RequestParam(value = "id", defaultValue = "1", required = true) Integer id,
          Model model) {
      model.addAttribute("name", name);
      model.addAttribute("id", id);
      model.addAttribute("product", new Product());
      return "singleProduct";
  }
}
