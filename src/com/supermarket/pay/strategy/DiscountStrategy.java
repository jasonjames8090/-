package com.supermarket.pay.strategy;

import com.supermarket.pay.model.Fruit;
import com.supermarket.pay.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 打折策略（针对特定水果）
 */
public class DiscountStrategy implements PromotionStrategy {
    private final String targetFruitName;
    private final BigDecimal rate;

    public DiscountStrategy(String targetFruitName, double rate) {
        this.targetFruitName = targetFruitName;
        this.rate = BigDecimal.valueOf(rate);
    }


    @Override
    public BigDecimal calculate(BigDecimal currentTotal, ShoppingCart cart) {
        BigDecimal discountAmount = BigDecimal.ZERO;
        for (var entry : cart.getItems().entrySet()) {
            if (entry.getKey().getName().equals(targetFruitName)) {
                BigDecimal originalItemPrice = entry.getKey().getPricePerJin()
                        .multiply(BigDecimal.valueOf(entry.getValue()));
                // 优惠金额 = 原价 * (1 - 折扣率)
                discountAmount = discountAmount.add(originalItemPrice.multiply(BigDecimal.ONE.subtract(rate)));
            }
        }
        return currentTotal.subtract(discountAmount);
    }
}