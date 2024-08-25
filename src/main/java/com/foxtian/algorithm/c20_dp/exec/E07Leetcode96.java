package com.foxtian.algorithm.c20_dp.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">96. 不同的二叉搜索树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/25 21:20
 * @Version 1.0
 */
public class E07Leetcode96 {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int j = 2; j <= n; j++) {
                for (int l = 0; l < j; l++) {
                    int r = j - l - 1;
                    dp[j] += dp[l] * dp[r];
                }
            }
            return dp[n];
        }
    }
}
