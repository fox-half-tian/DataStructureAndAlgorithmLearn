package com.foxtian.algorithm.c20_dp.exec;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/coin-change-ii/description/">518. 零钱兑换 II</a>
 *
 *
 * @Author 狐狸半面添
 * @Create 2024/8/24 21:20
 * @Version 1.0
 */
public class E02Leetcode518_1 {
    class Solution {
        public int change(int amount, int[] coins) {
        /*
                0   1   2   3   4   5
            2   1   0   1   0   1   0
            3   1   0   1   1   1   1
            1   1   1   2   3   4   5
            5   1   1   2   3   4   6
         */
            int[][] dp = new int[coins.length][amount + 1];
            dp[0][0] = 1;
            for (int j = coins[0]; j <= amount; j++) {
                dp[0][j] = dp[0][j - coins[0]];
            }

            for (int i = 1; i < coins.length; i++) {
                int coin = coins[i];
                // 放得下
                for (int j = 0; j <= amount; j++) {
                    if (j >= coin) {
                        dp[i][j] = dp[i][j - coin] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[coins.length - 1][amount];
        }
    }
}
