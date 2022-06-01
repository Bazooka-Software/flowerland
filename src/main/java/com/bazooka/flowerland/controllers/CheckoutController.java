package com.bazooka.flowerland.controllers;

import com.bazooka.flowerland.entities.ShippingAddress;
import com.bazooka.flowerland.entities.UserOrder;
import com.bazooka.flowerland.enums.OrderStatus;
import com.bazooka.flowerland.service.CartItemService;
import com.bazooka.flowerland.service.OrderItemService;
import com.bazooka.flowerland.service.ShippingAddressService;
import com.bazooka.flowerland.service.UserOrderService;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    UserOrderService userOrderService;
    @Autowired
    ShippingAddressService shippingAddressService;

    @Autowired
    OrderItemService orderItemService;

    @PostMapping("complete")
    public String completeCheckout(@ModelAttribute("userOrder") UserOrder order) {
        shippingAddressService.saveShippingAddress(order.getAddress());
        order.getOrderItems().forEach(o -> orderItemService.save(o));
        order.setStatus(OrderStatus.COMPLETED);
        userOrderService.saveOrder(order);
        return "complete";
    }
}
