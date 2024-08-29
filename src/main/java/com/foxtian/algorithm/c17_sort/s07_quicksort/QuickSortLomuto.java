package com.foxtian.algorithm.c17_sort.s07_quicksort;

/**
 * Description: 单边循环（lomuto 分区）
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 20:16
 * @Version 1.0
 */
public class QuickSortLomuto {

    public static void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // p 代表基准点元素索引
        int p = partition(arr, left, right);
        quick(arr, left, p - 1);
        quick(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 基准点元素值
        int pv = arr[right];
        // i 找比基准点大的元素
        int i = left;
        // j 找比基准点小的元素
        int j = left;
        while (j < right) {
            // j 找到比基准点小的元素了
            if (arr[j] < pv) {
                if (i != j) {
                    swap(arr, i, j);
                }
                // 1. i == j 则此时 i 和 j 都指向比基准点小的元素
                // 2. i != j 时 i 和 j 处的元素发生了交换，此时 i 指向的是比基准点小的元素
                // 这两种情况都需要 i++
                i++;
            }

            j++;
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
