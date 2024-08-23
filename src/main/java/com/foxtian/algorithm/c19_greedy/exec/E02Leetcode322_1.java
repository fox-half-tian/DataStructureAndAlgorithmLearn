package com.foxtian.algorithm.c19_greedy.exec;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 * 贪心算法存在问题
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 21:38
 * @Version 1.0
 */
public class E02Leetcode322_1 {
    int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        min = Integer.MAX_VALUE;
        rec(coins, coins.length - 1, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void rec(int[] coins, int index, int remainer, int count) {
        if (remainer < 0) {
            return;
        }
        if (remainer == 0) {
            if (min > count) {
                min  = count;
            }
            return;
        }

        count++;
        for (int i = index; i >= 0; i--) {
            rec(coins, i, remainer - coins[i], count);
        }
    }

    @Test
    public void testCoinChange() {
        int res = coinChange(new int[]{186,419,83,408}, 6249);
        System.out.println(res);

         res = coinChange(new int[]{1,10,15}, 21);
        System.out.println(res);
    }
}
