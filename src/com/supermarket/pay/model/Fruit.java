package com.supermarket.pay.model;

import java.math.BigDecimal;

public class Fruit {
    private final String name;
    private final BigDecimal pricePerJin;

    public Fruit(String name, double price) {
        this.name = name;
        this.pricePerJin = BigDecimal.valueOf(price);
    }
    public String getName() { return name; }
    public BigDecimal getPricePerJin() { return pricePerJin; }
}