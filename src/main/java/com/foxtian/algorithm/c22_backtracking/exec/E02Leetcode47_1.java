package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/permutations-ii/description/">47. 全排列 II</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 0:27
 * @Version 1.0
 */
public class E02Leetcode47_1 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, new boolean[nums.length], new LinkedList<>(), res);
            return res;
        }

        private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> deque, List<List<Integer>> res) {
            if (deque.size() == nums.length) {
                res.add(new ArrayList<>(deque));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 我们要求对于重复数字，前面的必须先访问才能访问后面的，这样就实现了对重复数字的内部有序性！
                // 找出重复数字，如果上一个数字没有被访问过，则进入下一轮
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }

                if (!visited[i]) {
                    visited[i] = true;
                    deque.offerLast(nums[i]);
                    dfs(nums, visited, deque, res);
                    // 回溯
                    deque.pollLast();
                    visited[i] = false;
                }
            }
        }
    }
}
