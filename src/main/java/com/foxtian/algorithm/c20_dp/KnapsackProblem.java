package com.foxtian.algorithm.c20_dp;

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
        System.out.println(select2(items, 10));
    }

    static int select(Item[] items, int total) {
        /*
                 0   1   2   3   4   5   6   7   8   9   10
             0
             1
             2
             3
         */
        int[][] dp = new int[items.length][total + 1];
        Item item = items[0];
        for (int i = item.weight; i <= total; i++) {
            dp[0][i] = item.value;
        }

        for (int i = 1; i < items.length; i++) {
             item = items[i];
            for (int j = 0; j <= total; j++) {
                // 如果背包放不下这个物品，则直接取无它时为最大价值
                if (j < item.weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 在有它和无它的价值之间取最大
                    dp[i][j] = Math.max(dp[i - 1][j - item.weight] + item.value, dp[i - 1][j]);
                }
            }
        }

        return dp[items.length - 1][total];
    }


    // 降维
    static int select2(Item[] items, int total) {
        /*
                 0   1   2   3   4   5   6   7   8   9   10
             0
             1
             2
             3
         */
        int[] dp = new int[total + 1];
        Item item0 = items[0];
        for (int i = item0.weight; i <= total; i++) {
            dp[i] = item0.value;
        }
        for (int i = 1; i < items.length; i++) {
            Item item = items[i];
            // 这个循环只考虑装得下，装不下则直接复用原来的
            for (int j = total; j >= item.weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - item.weight] + item.value);
            }
        }

        return dp[total];
    }
}
