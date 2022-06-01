package com.bazooka.flowerland.repository;

import com.bazooka.flowerland.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
