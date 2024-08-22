package com.foxtian.algorithm.c17_sort.s04_insertionsort;

/**
 * Description: 非递归版插入排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 20:20
 * @Version 1.0
 */
public class InsertSort1 {
    public static void sort(int[] arr) {
        for (int low = 1; low < arr.length; low++) {
            int inserted = arr[low];
            int i = low - 1;
            while (i >= 0 && arr[i] > inserted) {
                arr[i + 1] = arr[i];
                i--;
            }
            if (i != low - 1) {
                arr[i + 1] = inserted;
            }
        }
    }
}
