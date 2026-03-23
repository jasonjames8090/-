package com.supermarket.pay;

import com.supermarket.pay.model.Fruit;
import com.supermarket.pay.model.ShoppingCart;
import com.supermarket.pay.service.CheckoutService;
import com.supermarket.pay.strategy.DiscountStrategy;
import com.supermarket.pay.strategy.FullReductionStrategy;
import com.supermarket.pay.strategy.PromotionStrategy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();

        // 基础数据定义
        Fruit apple = new Fruit("苹果", 8);
        Fruit strawberry = new Fruit("草莓", 13);
        Fruit mango = new Fruit("芒果", 20);

        /**
         * 题目 1: 顾客 A (苹果 + 草莓)
         *
         * 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
         * 现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
         * 请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        ShoppingCart cartA = new ShoppingCart();
        cartA.addItem(apple, 5);      // 40元
        cartA.addItem(strawberry, 2); // 26元
        // todo 演示使用，暂时先用 ‘System.out.println’ 打印
        System.out.println("1. 顾客 A 总价: " + service.checkout(cartA, List.of())); // 66

        /**
         * 题目 2: 顾客 B (增加芒果)
         *
         * 2、超市增加了一种水果芒果，其定价为 20 元/斤。
         * 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
         * 请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        ShoppingCart cartB = new ShoppingCart();
        cartB.addItem(apple, 5);
        cartB.addItem(strawberry, 2);
        cartB.addItem(mango, 3);      // 60元
        System.out.println("2. 顾客 B 总价: " + service.checkout(cartB, List.of())); // 126

        /**
         * 题目 3: 顾客 C (草莓 8 折)
         *
         * 3、超市做促销活动，草莓限时打 8 折。
         * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
         * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        List<PromotionStrategy> strategiesC = List.of(new DiscountStrategy("草莓", 0.8));
        System.out.println("3. 顾客 C 总价: " + service.checkout(cartB, strategiesC)); // 120.8

        /**
         * 题目 4: 顾客 D (满 100 减 10)
         *
         * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
         * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
         * 请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        List<PromotionStrategy> strategiesD = List.of(
                new DiscountStrategy("草莓", 0.8),
                new FullReductionStrategy(100, 10)
        );
        System.out.println("4. 顾客 D 总价: " + service.checkout(cartB, strategiesD)); // 110.8
    }
}
