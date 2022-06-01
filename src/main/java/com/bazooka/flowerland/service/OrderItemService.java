package com.bazooka.flowerland.service;

import com.bazooka.flowerland.entities.OrderItem;
import com.bazooka.flowerland.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    public void save(OrderItem item) {
        orderItemRepository.save(item);
    }
}
