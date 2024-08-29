package com.foxtian.algorithm.c21_divideandconquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description: 快速选择算法
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 21:58
 * @Version 1.0
 */
public class QuickSelect {
    /*
        求排在第 i 名的元素，i 从 0 开始，由小到大排
        6   5   1   2   4
     */

    /*
        6   5   1   2   [4]

                2
        1   2   4   6   5

        1   2   4   6   [5]
                    3
        1   2   4   5   6
     */
    public static int select(int[] arr, int i) {
        return quick(arr, i, 0, arr.length - 1);
    }

    private static int quick(int[] arr, int i, int left, int right) {
        // 基准点
        int p = partition(arr, left, right);
        if (p < i) {
            return quick(arr, i, p + 1, right);
        } else if (i < p) {
            return quick(arr, i, left, p - 1);
        } else {
            return arr[p];
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, left, idx);

        int i = left + 1;
        int j = right;
        int pv = arr[left];
        while (i <= j) {
            while (i <= j && arr[i] < pv) {
                i++;
            }
            while (i <= j && arr[j] > pv) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 1, 2, 4};
        System.out.println(select(array, 0)); // 1
        System.out.println(select(array, 1)); // 2
        System.out.println(select(array, 2)); // 4
        System.out.println(select(array, 3)); // 5
        System.out.println(select(array, 4)); // 6
    }
}
