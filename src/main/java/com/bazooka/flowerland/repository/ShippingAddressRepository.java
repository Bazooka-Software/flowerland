package com.bazooka.flowerland.repository;

import com.bazooka.flowerland.entities.ShippingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Integer> {

}
