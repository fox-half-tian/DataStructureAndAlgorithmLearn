package com.foxtian.algorithm.c17_sort.s05_shellsort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class ShellSortTest {

    /**
     * 非递归版希尔排序测试，{@link ShellSort1#sort(int[])}
     */
    @Test
    public void testShellSort1() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        ShellSort1.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    /**
     * 递归版插入排序测试，{@link ShellSort2#sort(int[])}
     */
    @Test
    public void testShellSort2() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        ShellSort2.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
