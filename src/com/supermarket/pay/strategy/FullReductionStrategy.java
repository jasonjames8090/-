package com.supermarket.pay.strategy;

import com.supermarket.pay.model.Fruit;
import com.supermarket.pay.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 满减策略
 */
public class FullReductionStrategy implements PromotionStrategy {
    private final BigDecimal threshold;
    private final BigDecimal reduction;

    public FullReductionStrategy(double threshold, double reduction) {
        this.threshold = BigDecimal.valueOf(threshold);
        this.reduction = BigDecimal.valueOf(reduction);
    }

    @Override
    public BigDecimal calculate(BigDecimal currentTotal, ShoppingCart cart) {
        if (currentTotal.compareTo(threshold) >= 0) {
            return currentTotal.subtract(reduction);
        }
        return currentTotal;
    }
}