package com.foxtian.algorithm.c17_sort.s09_bucketsort;

import com.foxtian.algorithm.c17_sort.s08_countingsort.CountSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class BucketSortTest {

    /**
     * 桶排序测试，{@link BucketSort#sort(int[])}
     */
    @Test
    public void testBucketSort() {
        int[] arr = {6, 3, 4, 5, 2, 1, 7, 8};
        BucketSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);

        arr = new int[]{4, 1, 7, 14, 26, 15, 3, 32};
        BucketSort.sort(arr);
        assertArrayEquals(new int[]{1, 3, 4, 7, 14, 15, 26, 32}, arr);

        arr = new int[]{3, 2, 1, 4, 5, 2, 4, 3};
        BucketSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3, 4, 4, 5}, arr);
    }
}
