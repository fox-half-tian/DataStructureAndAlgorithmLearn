package com.foxtian.structure.c16_hashtable.exec;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description: <a href="https://leetcode.cn/problems/contains-duplicate/description/">217. 存在重复元素</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 23:27
 * @Version 1.0
 */
public class E04Leetcode217 {
    // 哈希表
    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // 排序
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
