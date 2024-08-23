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
public class E02Leetcode322_2 {

    public int coinChange(int[] coins, int amount) {
        int count = 0;
        for (int coin : coins) {
            while (amount > coin) {
                amount -= coin;
                count++;
            }
            if (amount == coin) {
                amount = 0;
                count++;
                break;
            }
        }

        return amount > 0 ? -1 : count;
    }

    @Test
    public void testCoinChange() {
        int res = coinChange(new int[]{5,2,1}, 21);
        System.out.println(res);
    }
}
