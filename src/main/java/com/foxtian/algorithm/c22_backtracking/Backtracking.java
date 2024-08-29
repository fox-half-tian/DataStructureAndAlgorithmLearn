package com.foxtian.algorithm.c22_backtracking;

import java.util.LinkedList;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 23:43
 * @Version 1.0
 */
public class Backtracking {
    public static void main(String[] args) {
        rec(1, new LinkedList<>());
    }

    static void rec(int n, LinkedList<Integer> stack) {
        if (n == 4) {
            return;
        }
        System.out.println("before: " + stack);
        stack.push(n);
        rec(n + 1, stack);
        stack.pop();
        System.out.println("after: " + stack);
    }
}
