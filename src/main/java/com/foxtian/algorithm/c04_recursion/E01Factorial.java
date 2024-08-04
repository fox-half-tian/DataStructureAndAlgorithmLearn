package com.foxtian.algorithm.c04_recursion;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 17:20
 * @Version 1.0
 */
public class E01Factorial {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
    }
}
