package com.foxtian.algorithm.sort.bubblesort;

/**
 * Description: 递归版本冒泡排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:08
 * @Version 1.0
 */
public class BubbleSort1 {

    public static void sort(int[] arr) {
        sort(arr, arr.length - 1);
    }

    /**
     * 递归函数在范围 [0...j] 内冒泡最大元素到右侧
     *
     * @param arr 数组
     * @param j   未排序区域右边界
     */
    private static void sort(int[] arr, int j) {
        if (j == 0) {
            return;
        }

        // 记录最后一次交换的位置
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                x = i;
            }
        }

        sort(arr, x);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
