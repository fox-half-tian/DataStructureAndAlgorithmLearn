package com.foxtian.algorithm.c17_sort.exec;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/sort-array-by-increasing-frequency/description/">1636. 按照频率将数组升序排序</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 1:04
 * @Version 1.0
 */
public class E02Leetcode1636 {
    public int[] frequencySort(int[] nums) {
        int minV = nums[0];
        int maxV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (minV > nums[i]) {
                minV = nums[i];
            }
            if (maxV < nums[i]) {
                maxV = nums[i];
            }
        }
        int len = maxV - minV + 1;
        int[] table = new int[len];
        for (int num : nums) {
            table[num - minV]++;
        }
        ArrayList<List<Integer>> counts = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            counts.add(new ArrayList<>());
        }

        for (int i = table.length - 1; i >= 0; i--) {
            int v = i + minV;
            int count = table[i];
            counts.get(count).add(v);
        }

        int k = 0;
        for(int count = 1; count < counts.size(); count++) {
            List<Integer> list = counts.get(count);
            if (!list.isEmpty()) {
                for (Integer v : list) {
                    for (int i = 0; i < count; i++) {
                        nums[k++] = v;
                    }
                }
            }
        }

        return nums;
    }
}
