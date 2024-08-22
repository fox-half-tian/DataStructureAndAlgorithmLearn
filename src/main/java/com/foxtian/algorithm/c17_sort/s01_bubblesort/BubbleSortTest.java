package com.foxtian.algorithm.c17_sort.s01_bubblesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class BubbleSortTest {

    /**
     * 递归版本冒泡排序测试，{@link BubbleSort1#sort(int[])}
     */
    @Test
    public void testBubbleSort1() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        BubbleSort1.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    /**
     * 非递归版本冒泡排序测试，{@link BubbleSort2#sort(int[])}
     */
    @Test
    public void testBubbleSort2() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        BubbleSort2.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
