package com.supermarket.pay.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Fruit, Integer> items = new LinkedHashMap<>();

    public void addItem(Fruit fruit, int weight) {
        if (weight < 0) throw new IllegalArgumentException("斤数不能为负数");
        items.put(fruit, items.getOrDefault(fruit, 0) + weight);
    }

    public Map<Fruit, Integer> getItems() { return items; }
}