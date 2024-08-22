package com.foxtian.algorithm.c17_sort.s05_shellsort;

/**
 * Description: 递归版希尔排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 21:38
 * @Version 1.0
 */
public class ShellSort2 {
    public static void sort(int[] arr) {
        sort(arr, arr.length >> 1);
    }

    private static void sort(int[] arr, int gap) {
        if (gap == 0) {
            return;
        }

        for (int low = gap; low < arr.length; low++) {
            int inserted = arr[low];
            int i = low - gap;
            while (i >= 0 && arr[i] > inserted) {
                arr[i + gap] = arr[i];
                i -= gap;
            }
            if (i != low - gap) {
                arr[i + gap] = inserted;
            }
        }
        sort(arr, gap >> 1);
    }
}
