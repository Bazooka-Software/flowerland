package com.bazooka.flowerland.enums;

public enum OrderStatus {
    COMPLETED("Completed"), FAILED("Failed"), DELIVERED("Delivered");

    private String status;
    private OrderStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return status;
    }
}
