package com.foxtian.algorithm.c17_sort.s02_selectsort;

/**
 * Description: 非递归版选择排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:33
 * @Version 1.0
 */
public class SelectionSort1 {
    public static void sort(int[] arr) {
        for (int right = arr.length - 1; right > 0; right--) {
            int index = right;
            for (int i = right - 1; i >= 0; i--) {
                if (arr[i] > arr[index]) {
                    index = i;
                }
            }
            swap(arr, index, right);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
