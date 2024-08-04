package com.foxtian.algorithm.c04_recursion;

import com.foxtian.utils.ArrayShowUtils;

/**
 * Description: 递归冒泡排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 17:39
 * @Version 1.0
 */
public class E04BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 0};
        sort(arr);
        System.out.println(ArrayShowUtils.getIntSingleArrayStr(arr));
    }

    public static void sort(int[] arr) {
        recursion(arr, arr.length - 1);
    }

    private static void recursion(int[] arr, int right) {
        if (right == 0) {
            return;
        }

        boolean happenSwap = false;
        for (int i = 0; i < right; i++) {
            if (arr[i] > arr[i + 1]) {
                happenSwap = true;
                swap(arr, i, i + 1);
            }
        }

        if (!happenSwap) {
            return;
        }

        recursion(arr, right - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
