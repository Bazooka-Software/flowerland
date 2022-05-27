package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import com.bazooka.flowerland.model.Cart;
import com.bazooka.flowerland.service.ProductService;
import org.hibernate.type.CharacterArrayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping({"/products"})
    public CompletableFuture<String> hello(@RequestParam(value = "name", defaultValue = "World",
            required = true) String name, Model model) throws ExecutionException, InterruptedException {
        List<Product> flowers = CompletableFuture.supplyAsync(() -> productService.retrieveProducts()).get();

        model.addAttribute("flowers", flowers);
        return CompletableFuture.supplyAsync(() -> "products");
    }
  /*  @GetMapping({"/all"})
    public String getAllProducts() {

        return "products";
    }*/
  @GetMapping({"/singleProduct"})
  public String singleProduct(
          @RequestParam(value = "productId") Integer id,
          Model model) {

      System.out.println(id);
      Product product = productService.findById(id);
      model.addAttribute("product", product);
      model.addAttribute("cartItem", new CartItem());
      return "singleProduct";
  }
}
