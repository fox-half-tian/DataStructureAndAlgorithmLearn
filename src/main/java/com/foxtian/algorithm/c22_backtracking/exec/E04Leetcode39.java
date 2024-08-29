package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/combination-sum/description/">39. 组合总和</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 1:33
 * @Version 1.0
 */
public class E04Leetcode39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates, target, 0, new LinkedList<>(), res);
            return res;
        }

        public void dfs(int[] candidates, int target, int start, LinkedList<Integer> deque, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(deque));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                // 剪枝，当前 candidate 过大
                if (candidate > target) {
                    return;
                }

                deque.offerLast(candidate);
                // 由于 candidate 可重复相加，因此 start 传 i 而不是 i + 1
                dfs(candidates, target - candidate, i, deque, res);
                // 回溯
                deque.pollLast();
            }
        }
    }
}
