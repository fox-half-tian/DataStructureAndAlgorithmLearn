package com.foxtian.algorithm.c17_sort.s08_countingsort;

/**
 * Description: 计数排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 22:21
 * @Version 1.0
 */
public class CountSort {
    public static void sort(int[] arr) {
        // 找出最大值和最小值
        int minV = arr[0];
        int maxV = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            if (minV > v) {
                minV = v;
            }
            if (maxV < v) {
                maxV = v;
            }
        }

        // 取值范围 [minV, maxV]
        int len = maxV - minV + 1;
        int[] table = new int[len];
        for (int v : arr) {
            // v 映射到计数表中的索引位置 i = v - minV
            table[v - minV]++;
        }

        int index = 0;
        for (int i = 0; i < table.length; i++) {
            // v 映射到计数表中的索引位置 i = v - minV，因此恢复 v 值 = i + minV
            int v = i + minV;
            // 值为 v 的数量
            int count = table[i];
            while (count > 0) {
                arr[index++] = v;
                count--;
            }
        }
    }
}
