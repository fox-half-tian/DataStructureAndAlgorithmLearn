package com.foxtian.algorithm.c17_sort.exec;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/maximum-gap/description/">164. 最大间距</a>
 * 桶排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 1:14
 * @Version 1.0
 */
public class E03Leetcode164_1 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        sort(nums);
        int maxR = 0;
        for (int i = 1; i < nums.length; i++) {
            int r = nums[i]-nums[i-1];
            if (maxR < r) {
                maxR = r;
            }
        }
        return maxR;
    }

    public static void sort(int[] arr) {
        sort(arr, 100);
    }

    private static void sort(int[] arr, int bucketCount) {
        int minV = arr[0];
        int maxV = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minV > arr[i]) {
                minV = arr[i];
            }
            if (maxV < arr[i]) {
                maxV = arr[i];
            }
        }
        // 示例：4, 1, 7, 14, 26, 15, 3, 32
        int c = maxV - minV + 1;
        bucketCount = Math.min(bucketCount, c);
        // 这里由于默认的 bucketCount 是内部给定的，因此我们在这里保证默认 bucketCount 肯定大于 1
        // 因此下面 if 为 true 只有可能是 maxV == minV 时，则此时说明数组内元素全都相同，无需排序
        if (bucketCount <= 1) {
            return;
        }

        // 创建桶
        ArrayList<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // bucketCount 假设为 10
        // range -> 4
        // index 0 [0, 3]   [1, 4]
        // index 1 [4, 7]   [5, 8]
        // index 2 [8, 11]  [9, 12]
        // ...
        // index 8 [32, 35] [33, 46]
        // index 9 [36, 40] [37, 41]
        int range = (c) % bucketCount == 0 ? c / bucketCount : c / bucketCount + 1;

        // 放入桶
        for (int v : arr) {
            buckets.get((v - minV) / range).add(v);
        }

        // 排序并放入 arr
        int i = 0;
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                if (range > 1) {
                    // 从小到大排序
                    bucket.sort((v1, v2) -> v1 - v2);
                }
                // 依次取出
                for (Integer v : bucket) {
                    arr[i++] = v;
                }
            }
        }
    }
}
