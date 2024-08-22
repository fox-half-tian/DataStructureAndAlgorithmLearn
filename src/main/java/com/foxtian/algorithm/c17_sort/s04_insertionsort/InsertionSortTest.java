package com.foxtian.algorithm.c17_sort.s04_insertionsort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class InsertionSortTest {

    /**
     * 非递归版插入排序测试，{@link InsertSort1#sort(int[])}
     */
    @Test
    public void testInsertSort1() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        InsertSort1.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    /**
     * 递归版插入排序测试，{@link InsertSort2#sort(int[])}
     */
    @Test
    public void testInsertSort2() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        InsertSort2.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
