package com.foxtian.algorithm.c20_dp;

/**
 * Description: 0-1 背包问题
 * 使用贪心算法存在问题
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:12
 * @Version 1.0
 */
public class KnapsackProblemComplete {
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
                new Item(0, 2, 3),
                new Item(1, 3, 4),
                new Item(2, 4, 7),
        };

        System.out.println(select(items, 10));
        System.out.println(select2(items, 10));
    }

    static int select(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        Item item0 = items[0];
        for (int i = item0.weight; i <= total; i++) {
            dp[0][i] = Math.max(dp[0][i - item0.weight] + item0.value, dp[0][i]);
        }

        for (int i = 1; i < items.length; i++) {
            Item item = items[i];
            for (int j = 0; j < items.length; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for (int j = item.weight; j <= total; j++) {
                dp[i][j] = Math.max(dp[i][j - item.weight] + item.value, dp[i - 1][j]);
            }
        }

        return dp[items.length - 1][total];
    }


    // 降维
    static int select2(Item[] items, int total) {
        int[] dp = new int[total + 1];
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            for (int j = item.weight; j <= total; j++) {
                dp[j] = Math.max(dp[j - item.weight] +item.value, dp[j]);
            }
        }

        return dp[total];
    }
}
