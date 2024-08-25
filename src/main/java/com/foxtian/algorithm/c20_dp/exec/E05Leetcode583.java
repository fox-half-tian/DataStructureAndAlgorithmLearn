package com.foxtian.algorithm.c20_dp.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/description/">583. 两个字符串的删除操作</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/25 20:37
 * @Version 1.0
 */
public class E05Leetcode583 {
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();

            int[] dp = new int[word2.length() + 1];
            for (int i = 0; i < chars1.length; i++) {
                int prev = 0;
                for (int j = 1; j <= chars2.length; j++) {
                    int temp = dp[j];
                    if (chars1[i] == chars2[j - 1]) {
                        dp[j] = prev + 1;
                    } else {
                        dp[j] = Integer.max(dp[j - 1], dp[j]);
                    }
                    prev = temp;
                }
            }
            return word1.length() + word2.length() - (dp[word2.length()] << 1);
        }
    }
}
