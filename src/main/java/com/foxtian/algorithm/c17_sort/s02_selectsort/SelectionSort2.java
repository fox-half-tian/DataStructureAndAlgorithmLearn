package com.foxtian.algorithm.c17_sort.s02_selectsort;

/**
 * Description: 递归版本选择排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:45
 * @Version 1.0
 */
public class SelectionSort2 {
    public static void sort(int[] arr) {
        sort(arr, arr.length - 1);
    }

    private static void sort(int[] arr, int right) {
        if (right == 0) {
            return;
        }

        int index = right;
        for (int i = right - 1; i >= 0; i--) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }

        if (index != right) {
            swap(arr, index, right);
        }

        sort(arr, right - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
