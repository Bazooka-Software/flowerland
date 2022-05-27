package com.bazooka.flowerland.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Version
    private Integer version;

    public CartItem(Product product, String sessionId) {
        this.product = product;
        this.sessionId = sessionId;
    }
    public CartItem(Product product, String sessionId, int quantity) {
        this.product = product;
        this.sessionId = sessionId;
        this.quantity = quantity;
    }
    public CartItem(String sessionId) {
        this.sessionId = sessionId;
    }
}

