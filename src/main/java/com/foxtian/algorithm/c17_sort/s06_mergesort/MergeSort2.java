package com.foxtian.algorithm.c17_sort.s06_mergesort;

/**
 * Description: 非递归版本归并排序
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 21:47
 * @Version 1.0
 */
public class MergeSort2 {
    public static void sort(int[] arr) {
        // width 代表有序区间的宽度，依次取值 1、2、4...
        for (int width = 1; width < arr.length; width <<= 1) {
            // [let, right] 分别代表待合并区间的左右边界
            for (int left = 0; left < arr.length; left += width << 1) {
                // 右边界应该是下一轮循环的左边界 - 1
                int right = left + (width << 1) - 1;
                // 防止越界
                right = Math.min(right, arr.length - 1);
                merge(arr, left, ((left + right) >>> 1) + 1, right);
            }
        }
    }

    /**
     * 合并两个有序区间，这里使用插入排序来完成
     * [start, low) 和 [low, end] 是两个有序区间
     *
     * @param arr
     * @param start
     * @param lowStart
     * @param end
     */
    private static void merge(int[] arr, int start, int lowStart, int end) {
        for (int low = lowStart; low <= end; low++) {
            int inserted = arr[low];
            int i = low - 1;
            while (i >= start && arr[i] > inserted) {
                arr[i + 1] = arr[i];
                i--;
            }
            if (i != low - 1) {
                arr[i + 1] = inserted;
            }
        }
    }

}
