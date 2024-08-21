package com.foxtian.structure.c16_hashtable.exec;

import java.util.HashMap;

/**
 * Description: <a href="https://leetcode.cn/problems/two-sum/description/">1. 两数之和</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 22:18
 * @Version 1.0
 */
public class E01Leetcode1 {
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        // k-元素值
        // v-索引位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
