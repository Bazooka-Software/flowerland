package com.bazooka.flowerland.entities;

import com.bazooka.flowerland.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "order_id")
    private ShippingAddress address;

    @OneToMany
    private List<OrderItem> orderItems;

    public UserOrder() {
        this.address = new ShippingAddress();
    }
}
