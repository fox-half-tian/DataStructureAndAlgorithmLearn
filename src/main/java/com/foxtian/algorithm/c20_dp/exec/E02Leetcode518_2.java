package com.foxtian.algorithm.c20_dp.exec;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/coin-change-ii/description/">518. 零钱兑换 II</a>
 * 降维
 *
 * @Author 狐狸半面添
 * @Create 2024/8/24 21:20
 * @Version 1.0
 */
public class E02Leetcode518_2 {
    class Solution {
        public int change(int amount, int[] coins) {
        /*
                0   1   2   3   4   5
            2   1   0   1   0   1   0
            3   1   0   1   1   1   1
            1   1   1   2   3   4   5
            5   1   1   2   3   4   6
         */
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            return dp[amount];
        }
    }
}
