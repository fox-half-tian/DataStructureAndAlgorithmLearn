package com.foxtian.algorithm.c19_greedy.exec;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Description: <a href="https://leetcode.cn/problems/coin-change-ii/description/">518. 零钱兑换 II</a>
 * 穷举法，会超时
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 21:01
 * @Version 1.0
 */
public class E01Leetcode518_1 {
    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return rec(coins.length - 1, coins, amount, new LinkedList<>());
    }

    /**
     *
     * @param index 当前硬币索引
     * @param coins 硬币面值数组
     * @param remainder 剩余金额
     * @param stack
     * @return 解的个数
     */
    public static int rec(int index,
                   int[] coins,
                   int remainder,
                   LinkedList<Integer> stack) {
        /**
         * 1.剩余金额 < 0 无解
         * 2.剩余金额 > 0 继续递归
         * 3.剩余金额 == 0 有解
         */
        if (remainder < 0) {
            System.out.println(stack.toString() + " [无解]");
            return 0;
        }
        if (remainder == 0) {
            System.out.println(stack.toString() + " [有解]");
            return 1;
        }

        int count = 0;
        for (int i = index; i >= 0; i--) {
            stack.push(coins[index]);
            count += rec(i, coins, remainder - coins[i], stack);
            stack.pop();
        }
        return count;
    }

    @Test
    public void testChange() {
        int res = change(5, new int[]{1, 2, 5});
        System.out.println(res);
    }
}
