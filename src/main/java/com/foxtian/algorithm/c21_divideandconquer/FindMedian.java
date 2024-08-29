package com.foxtian.algorithm.c21_divideandconquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description: 数组中的中位数-快速选择算法
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 22:21
 * @Version 1.0
 */
public class FindMedian {
    public static double findMedian(int[] arr) {
        int i = arr.length >> 1;
        int left = quickSelect(arr, i, 0, arr.length - 1);
        double midValue;
        if ((arr.length & 1) == 1) { // 奇数
            midValue = left;
        } else { // 偶数
            // int right = quickSelect(arr, i + 1, i + 1, arr.length - 1);
            int right = quickSelect(arr, i - 1, 0, i);
            midValue = (left + right) / 2.0;
        }
        return midValue;
    }

    private static int quickSelect(int[] arr, int i, int left, int right) {
        int p = partition(arr, left, right);
        if (p < i) {
            return quickSelect(arr, i, p + 1, right);
        } else if (i < p) {
            return quickSelect(arr, i, left, p - 1);
        } else {
            return arr[p];
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // 基准点
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, left, idx);

        int pv = arr[left];
        int i = left + 1;
        int j = right;
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
        System.out.println(findMedian(new int[]{4, 5, 1})); // 4.0
        System.out.println(findMedian(new int[]{4, 5, 1, 6, 3})); // 4.0
        System.out.println(findMedian(new int[]{3, 1, 5, 4})); // 3.5
        System.out.println(findMedian(new int[]{3, 1, 5, 4, 7, 8})); // 4.5
    }
}
