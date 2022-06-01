package com.bazooka.flowerland.service;

import com.bazooka.flowerland.entities.UserOrder;
import com.bazooka.flowerland.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Service
@RequestScope
public class UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    public List<UserOrder> getAllOrders() {
        return (List<UserOrder>) userOrderRepository.findAll();
    }

    public void saveOrder(UserOrder order) {
        userOrderRepository.save(order);
    }
}
