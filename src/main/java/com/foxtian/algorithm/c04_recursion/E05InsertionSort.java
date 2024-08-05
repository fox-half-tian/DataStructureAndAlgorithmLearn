package com.foxtian.algorithm.c04_recursion;

import com.foxtian.utils.ArrayShowUtils;

/**
 * Description: 插入排序递归实现
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 18:00
 * @Version 1.0
 */
public class E05InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 0};
        sort(arr);
        System.out.println(ArrayShowUtils.getIntSingleArrayStr(arr));
    }

    public static void sort(int[] arr) {
        recursion(arr, 1);
    }

    private static void recursion(int[] arr, int low) {
        if (arr.length <= low) {
            return;
        }

        int value = arr[low];
        int i;
        for (i = low - 1; i >= 0; i--) {
            if (value < arr[i]) {
                arr[i + 1] = arr[i];
            }else {
                break;
            }
        }
        if (low != i + 1) {
            arr[i + 1] = value;
        }

        recursion(arr, low + 1);
    }
}
