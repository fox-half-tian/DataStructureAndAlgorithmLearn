package com.foxtian.algorithm.sort.selectsort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class SelectionSortTest {

    /**
     * 非递归版本选择排序测试，{@link SelectionSort1#sort(int[])}
     */
    @Test
    public void testSelectionSort1() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        SelectionSort1.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    /**
     * 递归版本选择排序测试，{@link SelectionSort2#sort(int[])}
     */
    @Test
    public void testSelectionSort2() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        SelectionSort2.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
