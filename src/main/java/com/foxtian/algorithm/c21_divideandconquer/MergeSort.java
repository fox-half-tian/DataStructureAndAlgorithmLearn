package com.foxtian.algorithm.c21_divideandconquer;

import com.foxtian.algorithm.c17_sort.s06_mergesort.MergeSort1;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description: 递归版归并排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 21:33
 * @Version 1.0
 */
public class MergeSort {

    public static void sort(int[] arr) {
        int[] sortArr = new int[arr.length];
        split(arr, sortArr, 0, arr.length - 1);
    }

    private static void split(int[] arr, int[] sortArr, int left, int right) {
        if (right - left <= 1) {
            merge(arr, sortArr, left, left + 1, right);
            return;
        }

        int m = (left + right) >>> 1;
        split(arr, sortArr, left, m);
        split(arr, sortArr, m + 1, right);
        merge(arr, sortArr, left, m + 1, right);
    }

    private static void merge(int[] arr, int[] sortArr, int start, int lowStart, int end) {
        int i = start;
        int j = lowStart;
        int k = start;
        while (i < lowStart && j <= end) {
            if (arr[i] <= arr[j]) {
                sortArr[k++] = arr[i];
                i++;
            } else {
                sortArr[k++] = arr[j];
                j++;
            }
        }

        if (i < lowStart) {
            while (i < lowStart) {
                sortArr[k++] = arr[i];
                i++;
            }
        } else {
            while (j <= end) {
                sortArr[k++] = arr[j];
                j++;
            }
        }

        System.arraycopy(sortArr, start, arr, start, end - start + 1);
    }
}
