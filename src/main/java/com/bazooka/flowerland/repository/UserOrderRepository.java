package com.bazooka.flowerland.repository;

import com.bazooka.flowerland.entities.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserOrderRepository extends CrudRepository<UserOrder, Integer> {
}
