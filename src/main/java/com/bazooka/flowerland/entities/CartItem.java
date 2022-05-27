package com.bazooka.flowerland.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;

    private String sessionId;

    public CartItem(Product product, String sessionId) {
        this.product = product;
        this.sessionId = sessionId;
    }
}
