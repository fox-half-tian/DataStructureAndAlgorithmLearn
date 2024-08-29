package com.foxtian.algorithm.c17_sort.s07_quicksort;

import com.foxtian.algorithm.c17_sort.s06_mergesort.MergeSort1;
import com.foxtian.algorithm.c17_sort.s06_mergesort.MergeSort2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class QuickSortTest {

    /**
     * 单边排序测试，{@link QuickSortLomuto#sort(int[])}
     */
    @Test
    public void testQuickSortLomuto() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        QuickSortLomuto.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    /**
     * 双边排序测试，{@link QuickSortHoare#sort(int[])}
     */
    @Test
    public void testQuickSortHoare() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        QuickSortHoare.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
