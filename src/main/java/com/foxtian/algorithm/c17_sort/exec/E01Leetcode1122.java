package com.foxtian.algorithm.c17_sort.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/relative-sort-array/description/">1122. 数组的相对排序</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 0:35
 * @Version 1.0
 */
public class E01Leetcode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计数排序
        int[] table = new int[1001];
        for (int v : arr1) {
            table[v]++;
        }

        int k = 0;
        for (int v : arr2) {
            while (table[v] > 0) {
                arr1[k++] = v;
                table[v]--;
            }
        }
        for (int v = 0; v < table.length; v++) {
            while (table[v] > 0) {
                arr1[k++] = v;
                table[v]--;
            }
        }

        return arr1;
    }
}
