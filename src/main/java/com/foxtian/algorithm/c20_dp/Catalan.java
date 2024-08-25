package com.foxtian.algorithm.c20_dp;

/**
 * Description: 卡特兰数
 *
 * @Author 狐狸半面添
 * @Create 2024/8/25 21:32
 * @Version 1.0
 */
public class Catalan {
    static int catalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int j = 2; j <= n; j++) {
            // j = 4
            // (0, 3) (1, 2) (2, 1) (3, 0)
            for (int l = 0; l < j; l++) { // l 表示左边节点个数
                int r = j - l - 1; // r 表示右边节点个数
                dp[j] += dp[l] * dp[r];
            }
        }

        return dp[n];
    }
}
