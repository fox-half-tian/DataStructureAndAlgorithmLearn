package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/combinations/description/">77. 组合</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 1:19
 * @Version 1.0
 */
public class E03Leetcode77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(n, k, 1, new LinkedList<>(), res);
            return res;
        }

        public void dfs(int n, int k, int start, LinkedList<Integer> deque, List<List<Integer>> res) {
            if (deque.size() == k) {
                res.add(new ArrayList<>(deque));
                return;
            }

            // 还差的数目：k - deque.size()
            // 还剩的数目：n - i + 1
            // 如果还差的数目 > 还剩的数目，则没有必要继续递归
            // 即 k - deque.size() > n - i + 1 时 => i > n + 1 - (k - deque.size())
            int t = n + 1 - (k - deque.size());
            for (int i = start; i <= n; i++) {
                // 剪枝
                if (i > t) {
                    return;
                }

                deque.offerLast(i);

                dfs(n, k, i + 1, deque, res);

                // 回溯
                deque.pollLast();
            }
        }


    }
}
