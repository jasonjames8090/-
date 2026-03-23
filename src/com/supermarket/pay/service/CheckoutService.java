package com.supermarket.pay.service;// CheckoutService.java
import com.supermarket.pay.model.ShoppingCart;
import com.supermarket.pay.strategy.PromotionStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CheckoutService {
    public BigDecimal checkout(ShoppingCart cart, List<PromotionStrategy> strategies) {
        // 1. 计算原价总和
        BigDecimal total = BigDecimal.ZERO;
        for (var entry : cart.getItems().entrySet()) {
            total = total.add(entry.getKey().getPricePerJin()
                    .multiply(BigDecimal.valueOf(entry.getValue())));
        }

        // 2. 链式应用促销策略
        for (PromotionStrategy strategy : strategies) {
            total = strategy.calculate(total, cart);
        }

        // 3. 保留两位小数，四舍五入
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}