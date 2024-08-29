package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/permutations/description/">46. 全排列</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 0:15
 * @Version 1.0
 */
public class E01Leetcode46_1 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, 0, res);
            return res;
        }

        public void dfs(int[] nums, int start, List<List<Integer>> res) {
            if (start == nums.length) {
                List<Integer> list = new ArrayList<>(nums.length);
                for (int num : nums) {
                    list.add(num);
                }
                res.add(list);
                return;
            }

            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);

                dfs(nums, start + 1, res);

                // 回溯
                swap(nums, start, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
