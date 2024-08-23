package com.foxtian.algorithm.c19_greedy;

import java.util.Arrays;

/**
 * Description: 分数背包问题
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:04
 * @Version 1.0
 */
public class FractionalKnapsackProblem {
    static class Item {
        int index;
        int weight;
        int value;

        int unitValue;

        public Item(int index, int weight, int value) {
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public int unitValue() {
            if (unitValue == 0) {
                unitValue = value / weight;
            }
            return unitValue;
        }
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(0, 4, 24),
                new Item(1, 8, 160),
                new Item(2, 2, 4000),
                new Item(3, 6, 108),
                new Item(4, 1, 4000)
        };

        System.out.println(select(items, 10));
    }

    static int select(Item[] items, int total) {
        Arrays.sort(items, (i1, i2) -> i2.unitValue() - i1.unitValue());
        // 最大价值
        int max = 0;
        for (Item item : items) {
            // 可以拿完
            if (total >= item.weight) {
                total -= item.weight;
                max += item.value;
            }  else {
                // 拿不完
                max += item.unitValue() * total;
                total = 0;
            }
        }

        return max;
    }
}
