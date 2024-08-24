package com.foxtian.algorithm.c20_dp.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/unique-paths/description/">62. 不同路径</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:40
 * @Version 1.0
 */
public class E01Leetcode62_1 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][1] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m][n];
        }
    }
}
