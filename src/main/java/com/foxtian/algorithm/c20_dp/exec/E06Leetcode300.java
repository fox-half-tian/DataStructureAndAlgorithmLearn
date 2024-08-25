package com.foxtian.algorithm.c20_dp.exec;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/25 21:18
 * @Version 1.0
 */
public class E06Leetcode300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
        /*
                        1       2       3       4
                1       3       6       4       9
                1       13      16      14      19
                                136     134     139
                                                169
                                                1369
                                                149
                                                1349
               (1)    (2)      (3)     (3)      (4)
                                                4
         */
            // dp[i] 表示包含 num[i] 时的最长递增子序列
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    // 满足升序条件
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }

            return max;
        }
    }
}
