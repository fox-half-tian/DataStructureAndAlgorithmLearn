package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/combination-sum-ii/description/">组合总数 II</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 9:58
 * @Version 1.0
 */
public class E05Leetcode40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates, target, 0, new boolean[candidates.length], new LinkedList<>(), res);
            return res;
        }

        private void dfs(int[] candidates, int target, int start, boolean[] visited, LinkedList<Integer> deque, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(deque));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];

                // 剪枝1
                if (candidate > target) {
                    return;
                }

                // 剪枝2：必须保证相同元素的使用顺序不变
                if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) {
                    continue;
                }


                visited[i] = true;
                deque.offerLast(candidate);

                dfs(candidates, target - candidate, i + 1, visited, deque, res);

                // 回溯
                deque.pollLast();
                visited[i] = false;
            }
        }
    }
}
