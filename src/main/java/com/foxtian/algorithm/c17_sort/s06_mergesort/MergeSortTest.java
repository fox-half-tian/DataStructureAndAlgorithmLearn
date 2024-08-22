package com.foxtian.algorithm.c17_sort.s06_mergesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class MergeSortTest {

    /**
     * 非递归版希尔排序测试，{@link MergeSort2#sort(int[])}
     */
    @Test
    public void testMergeSort1() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        MergeSort2.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    /**
     * 递归版归并排序测试，{@link MergeSort1#sort(int[])}
     */
    @Test
    public void testMergeSort2() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        MergeSort1.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
