package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/combination-sum-iii/description/">216. 组合总和 III</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 10:21
 * @Version 1.0
 */
public class E06Leetcode216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(k, n, 1, new LinkedList<>(), res);
            return res;
        }

        private void dfs(int k, int n, int start, LinkedList<Integer> deque, List<List<Integer>> res) {
            if (n == 0) {
                if (k == 0) {
                    res.add(new ArrayList<>(deque));
                }
                return;
            }

            // 还需要的个数：k - deque.size()
            // 还剩余的个数：9 - i + 1
            // 如果 还剩余的个数 < 还需要的个数，则不必再查找
            // 即 9 - i + 1 < k - deque.size() => i > 10 - k + deque.size()
            int t = 10 - k + deque.size();
            for (int i = start; i <= 9; i++) {
                // 剪枝
                if (i > t || i > n) {
                    return;
                }

                deque.offerLast(i);
                dfs(k - 1, n - i, i + 1, deque, res);
                // 回溯
                deque.pollLast();
            }
        }
    }
}
