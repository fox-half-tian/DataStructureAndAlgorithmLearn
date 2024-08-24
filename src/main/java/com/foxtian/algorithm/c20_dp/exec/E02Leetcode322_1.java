package com.foxtian.algorithm.c20_dp.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/24 21:20
 * @Version 1.0
 */
public class E02Leetcode322_1 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[][] dp = new int[coins.length][amount + 1];
            // 无组合策略的标识
            int flag = amount + 1;
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[0]) {
                    dp[0][j] = dp[0][j - coins[0]] + 1;
                } else {
                    dp[0][j] = flag;
                }
            }

            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) {
                        dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            int count = dp[coins.length - 1][amount];
            return count < flag ? count : -1;
        }
    }
}
