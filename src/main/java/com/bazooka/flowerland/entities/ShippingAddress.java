package com.bazooka.flowerland.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String city;
    String street;
    Integer houseNumber;
}
