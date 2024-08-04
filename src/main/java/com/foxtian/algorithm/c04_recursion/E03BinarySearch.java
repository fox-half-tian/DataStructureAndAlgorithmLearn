package com.foxtian.algorithm.c04_recursion;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 17:31
 * @Version 1.0
 */
public class E03BinarySearch {
    public static int search(int[] arr, int target) {
        return recursion(arr, target, 0, arr.length - 1);
    }

    private static int recursion(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int m = (left + right) >>> 1;
        if (target < arr[m]) {
            right = m - 1;
        } else if (arr[m] < target) {
            left = m + 1;
        } else {
            return m;
        }
        return recursion(arr, target, left, right);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int targetIndex = search(arr, 5);
        System.out.println(targetIndex);
    }
}
