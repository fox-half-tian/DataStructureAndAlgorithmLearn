package com.foxtian.algorithm.c17_sort.s10_radixsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 基数排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 23:56
 * @Version 1.0
 */
public class RadixSort {
    public static void sort(String[] strs) {
        // 建立桶
        List<List<String>> buckets = new ArrayList<>(128);
        // 初始化桶
        for (int i = 0; i < 128; i++) {
            buckets.add(new ArrayList<>());
        }

        // 从后往前遍历
        for (int i = strs[0].length() - 1; i >= 0; i--) {
            // 依次加入桶
            for (String str : strs) {
                buckets.get(str.charAt(i)).add(str);
            }
            // 依次从桶中取出元素放回数组，并清空桶
            int k = 0;
            for (List<String> bucket : buckets) {
                for (String str : bucket) {
                    strs[k++] = str;
                }
                bucket.clear();
            }
        }
    }

}
