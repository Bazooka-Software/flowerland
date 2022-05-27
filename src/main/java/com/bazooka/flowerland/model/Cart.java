package com.bazooka.flowerland.model;

import com.bazooka.flowerland.entities.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private List<CartItem> cartItems;
}
