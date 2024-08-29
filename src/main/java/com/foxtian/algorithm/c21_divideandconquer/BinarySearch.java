package com.foxtian.algorithm.c21_divideandconquer;

/**
 * Description: 二分查找
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 21:26
 * @Version 1.0
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        return recursion(arr, target, 0, arr.length - 1);
    }

    private static int recursion(int[] arr, int target, int i, int j) {
        if (i > j) {
            return -1;
        }

        int m = (i + j) >>> 1;
        if (arr[m] < target) {
            return recursion(arr, target, m + 1, j);
        } else if (target < arr[m]) {
            return recursion(arr, target, i, m - 1);
        } else {
            return m;
        }
    }

}
