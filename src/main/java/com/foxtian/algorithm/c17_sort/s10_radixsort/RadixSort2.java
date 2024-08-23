package com.foxtian.algorithm.c17_sort.s10_radixsort;

import java.util.ArrayList;

/**
 * Description: 基数排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 1:21
 * @Version 1.0
 */
public class RadixSort2 {
    public static void sort(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // 创建桶
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        int m = 1;
        while (m <= max) {
            // 加入桶
            for (int num : nums) {
                buckets[num / m % 10].add(num);
            }

            // 从桶中取出，并清空桶
            int k = 0;
            for (int i = 0; i < 10; i++) {
                if (!buckets[i].isEmpty()) {
                    for (Integer num : buckets[i]) {
                        nums[k++] = num;
                    }
                    buckets[i].clear();
                }
            }

            m *= 10;
        }
    }
}
