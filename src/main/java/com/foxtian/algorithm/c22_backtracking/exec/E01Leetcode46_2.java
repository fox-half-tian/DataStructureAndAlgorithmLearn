package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/permutations/description/">46. 全排列</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 0:15
 * @Version 1.0
 */
public class E01Leetcode46_2 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, new boolean[nums.length], new LinkedList<>(), res);
            return res;
        }

        public void dfs(int[] nums, boolean[] visited, LinkedList<Integer> deque, List<List<Integer>> res) {
            if (deque.size() == nums.length) {
                res.add(new ArrayList<>(deque));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
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
