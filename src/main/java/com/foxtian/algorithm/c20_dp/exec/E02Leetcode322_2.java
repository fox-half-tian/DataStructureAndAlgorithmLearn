package com.foxtian.algorithm.c20_dp.exec;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 * 降维
 *
 * @Author 狐狸半面添
 * @Create 2024/8/24 21:20
 * @Version 1.0
 */
public class E02Leetcode322_2 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
                }
            }
            return dp[amount] < amount + 1 ? dp[amount] : -1;
        }
    }
}
