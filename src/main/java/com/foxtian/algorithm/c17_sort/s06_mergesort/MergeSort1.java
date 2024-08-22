package com.foxtian.algorithm.c17_sort.s06_mergesort;

/**
 * Description: 递归版本归并排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 21:47
 * @Version 1.0
 */
public class MergeSort1 {
    public static void sort(int[] arr) {
        split(arr, 0, arr.length - 1);
    }

    private static void split(int[] arr, int left, int right) {
        // 2.治，在数据量较小时，使用插入排序来解决，而不是 left 和 right 非常小了才治
        if (right - left <= 32) {
            merge(arr, left, left + 1, right);
            return;
        }

        // 1.分
        int m = (left + right) >>> 1;
        split(arr, left, m);
        split(arr, m + 1, right);

        // 3.合
        merge(arr, left, m + 1, right);
    }

    /**
     * 合并两个有序区间，这里使用插入排序来完成
     * [start, low) 和 [low, end] 是两个有序区间
     *
     * @param arr
     * @param start
     * @param lowStart
     * @param end
     */
    private static void merge(int[] arr, int start, int lowStart, int end) {
        for (int low = lowStart; low <= end; low++) {
            int inserted = arr[low];
            int i = low - 1;
            while (i >= start && arr[i] > inserted) {
                arr[i + 1] = arr[i];
                i--;
            }
            if (i != low - 1) {
                arr[i + 1] = inserted;
            }
        }
    }

}
