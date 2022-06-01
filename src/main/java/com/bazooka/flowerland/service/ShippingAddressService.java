package com.bazooka.flowerland.service;

import com.bazooka.flowerland.entities.ShippingAddress;
import com.bazooka.flowerland.entities.UserOrder;
import com.bazooka.flowerland.repository.ShippingAddressRepository;
import com.bazooka.flowerland.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Service
@RequestScope
public class ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    public void saveShippingAddress(ShippingAddress address) {
        shippingAddressRepository.save(address);
    }
}
