package com.foxtian.algorithm.c20_dp.exec;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/unique-paths/description/">62. 不同路径</a>
 * 降维
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:40
 * @Version 1.0
 */
public class E01Leetcode62_2 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 2; j <= n; j++) {
                    dp[j] += dp[j - 1];
                }
            }

            return dp[n];
        }
    }
}
