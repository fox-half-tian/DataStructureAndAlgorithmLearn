package com.foxtian.algorithm.c17_sort.s07_quicksort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description: 双边循环
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 20:16
 * @Version 1.0
 */
public class QuickSortHoare {

    public static void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // p 代表基准点元素索引
        int p = partition(arr, left, right);
        quick(arr, left, p - 1);
        quick(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 使用随机数作为基准点，避免万一最大值或最小值作为基准点导致的分区不均衡
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, left, idx);

        int pv = arr[left];
        int j = right;
        int i = left + 1;
        /*
            为什么还需要在 i == j 时进入循环
            因为当 i == j 时，如果 i 和 j 指向的是大于等于基准点的元素
            则在最左侧的基准点与 j 交换会得到错误的顺序！
            所以要进入循环，i 的 while 不会进入，j 的 while 会进入一次并指向了小于等于基准点的元素
            因此，i == j 时进入循环的目的是保证最终 j 指向的小于等于基准点的元素，这是交换 j 与 left 才是有效顺序
         */
        while (i <= j) {
            // i 遇到大于等于基准点的元素停止
            while (i <= j && arr[i] < pv) {
                i++;
            }

            // j 遇到小于等于基准点的元素停止
            while (i <= j && arr[j] > pv) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, j, left);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
