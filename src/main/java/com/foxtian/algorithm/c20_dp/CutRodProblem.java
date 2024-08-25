package com.foxtian.algorithm.c20_dp;

/**
 * Description: 钢条切割问题
 *
 * @Author 狐狸半面添
 * @Create 2024/8/24 22:49
 * @Version 1.0
 */
public class CutRodProblem {
    static int cut(int[] values, int n) {
        int[][] dp = new int[values.length][n + 1];
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    // 放得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[values.length - 1][n];
    }

    public static void main(String[] args) {
        System.out.println(cut(new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30}, 4));
    }
}
