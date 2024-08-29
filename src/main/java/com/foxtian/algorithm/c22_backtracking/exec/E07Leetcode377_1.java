package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description: <a href="https://leetcode.cn/problems/combination-sum-iv/description/">377. 组合总和 Ⅳ</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 10:29
 * @Version 1.0
 */
public class E07Leetcode377_1 {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            dfs(nums, target, 0, new LinkedList<>());
            return count;
        }

        int count = 0;

        private void dfs(int[] nums, int target, int start, LinkedList<Integer> deque) {
            if (target == 0) {
                count++;
                return;
            }

            for (int i = start; i < nums.length; i++) {
                int num = nums[i];
                if (num > target) {
                    return;
                }

                deque.offerLast(num);
                dfs(nums, target - num, start, deque);
                // 回溯
                deque.pollLast();
            }
        }
    }
}
