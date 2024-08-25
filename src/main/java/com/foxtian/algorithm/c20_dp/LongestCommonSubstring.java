package com.foxtian.algorithm.c20_dp;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/25 0:32
 * @Version 1.0
 */
public class LongestCommonSubstring {
    public static int longestCommonSubstring(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int max = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Integer.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("xt_foxc", "foxxt"));
    }
}
