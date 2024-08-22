package com.foxtian.algorithm.c17_sort.s_03heapsort;

import com.foxtian.algorithm.c17_sort.s02_selectsort.SelectionSort1;
import com.foxtian.algorithm.c17_sort.s02_selectsort.SelectionSort2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class HeapSortTest {

    /**
     * 堆排序测试，{@link HeapSort#sort(int[])}
     */
    @Test
    public void testHeapSort() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }
}
