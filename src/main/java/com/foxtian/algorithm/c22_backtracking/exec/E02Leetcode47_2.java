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
public class E02Leetcode47_2 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, 0, res);
            return res;
        }

        private void dfs(int[] nums, int start, List<List<Integer>> res) {
            if (start == nums.length) {
                List<Integer> list = new ArrayList<>(nums.length);
                for (int num : nums) {
                    list.add(num);
                }
                res.add(list);
            }

            for (int i = start; i < nums.length; i++) {
                if (isRepeat(nums, start, i)) {
                    continue;
                }

                swap(nums, start, i);
                dfs(nums, start + 1, res);
                swap(nums, start, i);
            }
        }

        private boolean isRepeat(int[] nums, int start, int swapPoint) {
            int j = start;
            while (j < swapPoint) {
                if (nums[j] == nums[swapPoint]) {
                    return true;
                }
                j++;
            }
            return false;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
