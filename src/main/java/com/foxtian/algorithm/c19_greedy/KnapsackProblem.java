package com.foxtian.algorithm.c19_greedy;

import java.util.Arrays;

/**
 * Description: 0-1 背包问题
 * 使用贪心算法存在问题
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:12
 * @Version 1.0
 */
public class KnapsackProblem {
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
                new Item(0, 1, 1_000_000),
                new Item(1, 4, 1600),
                new Item(2, 8, 2400),
                new Item(3, 5, 30)
        };

        System.out.println(select(items, 10));
    }

    static int select(Item[] items, int total) {
        Arrays.sort(items, (i1, i2)->i2.unitValue() - i1.unitValue());
        int max = 0;
        for (Item item : items) {
            if (total >= item.weight) {
                total -= item.weight;
                max += item.value;
            }
        }
        return max;
    }
}
