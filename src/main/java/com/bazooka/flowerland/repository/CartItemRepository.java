package com.bazooka.flowerland.repository;

import com.bazooka.flowerland.entities.CartItem;
import com.bazooka.flowerland.entities.Product;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    CartItem save(CartItem c);
    Iterable<CartItem> findAll();
    List<CartItem> findAllBySessionId(String sessionId);
    List<CartItem> findAllByProduct(Product product);
    List<CartItem> findAllByProductAndSessionId(Product product, String sessionId);
}
