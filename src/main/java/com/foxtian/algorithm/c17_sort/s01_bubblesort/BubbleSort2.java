package com.foxtian.algorithm.c17_sort.s01_bubblesort;

/**
 * Description: 非递归冒泡排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:18
 * @Version 1.0
 */
public class BubbleSort2 {
    public static void sort(int[] arr) {
        int j = arr.length - 1;
        do {
            // 记录最后一次交换位置
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    // 记录当前交换的位置
                    x = i;
                }
            }
            // 下一轮冒泡从最后一次交换位置开始
            j = x;
        } while (j != 0);
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
