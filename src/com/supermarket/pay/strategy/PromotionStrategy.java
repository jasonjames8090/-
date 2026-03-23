package com.supermarket.pay.strategy;

import com.supermarket.pay.model.Fruit;
import com.supermarket.pay.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

public interface PromotionStrategy {
    BigDecimal calculate(BigDecimal currentTotal, ShoppingCart cart);
}