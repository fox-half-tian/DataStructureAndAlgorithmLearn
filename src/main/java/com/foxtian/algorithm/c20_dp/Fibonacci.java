package com.foxtian.algorithm.c20_dp;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:21
 * @Version 1.0
 */
public class Fibonacci {
    public static void main(String[] args) {
        // 0 1 1 2 3 5 8
        System.out.println(fibonacci1(6));
        System.out.println(fibonacci2(6));
    }

    public static int fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int t = first + second;
            first = second;
            second = t;
        }

        return second;
    }
}
