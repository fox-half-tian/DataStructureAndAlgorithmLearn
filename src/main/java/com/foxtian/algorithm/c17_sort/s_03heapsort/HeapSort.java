package com.foxtian.algorithm.c17_sort.s_03heapsort;

/**
 * Description: 堆排序，这里使用大顶堆
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:53
 * @Version 1.0
 */
public class HeapSort {
    public static void sort(int[] arr) {
        // 建堆
        heapify(arr);

        // 依次取出堆顶元素
        int size = arr.length;
        while (size > 1) {
            // 取出堆顶元素放到尾部
            swap(arr, 0, size - 1);
            // 元素个数减少
            size--;
            // 恢复大顶堆结构
            down(arr, 0, size);
        }
    }

    /**
     * 建堆，从最后一个非叶子节点开始从后往前下潜
     *
     * @param arr
     */
    private static void heapify(int[] arr) {
        for (int i = (arr.length - 1 - 1) >> 1; i >= 0; i--) {
            down(arr, i, arr.length);
        }
    }

    /**
     * 非递归版下潜，性能由于递归版
     *
     * @param arr
     * @param parent
     * @param size   记录此时 arr 中的元素个数，即堆中元素范围是 [0, size)
     */
    private static void down(int[] arr, int parent, int size) {
        while (true) {
            int left = (parent << 1) + 1;
            int right = left + 1;
            int max = parent;

            if (left < size && arr[left] > arr[max]) {
                max = left;
            }
            if (right < size && arr[right] > arr[max]) {
                max = right;
            }

            if (max != parent) {
                // 找到更大孩子
                swap(arr, max, parent);
                parent = max;
            } else {
                // 没找到更大孩子
                break;
            }
        }
    }

    /**
     * 递归版下潜
     *
     * @param arr
     * @param parent
     * @param size
     */
    private static void downRecursion(int[] arr, int parent, int size) {
        int left = (parent << 1) + 1;
        int right = left + 1;
        int max = parent;

        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }

        if (max != parent) {
            swap(arr, max, parent);
            downRecursion(arr, max, size);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
