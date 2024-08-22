package com.foxtian.algorithm.c17_sort.s10_radixsort;

import com.foxtian.algorithm.c17_sort.s09_bucketsort.BucketSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 19:13
 * @Version 1.0
 */
public class RadixSortTest {

    /**
     * 桶排序测试，{@link RadixSort#sort(String[])}
     */
    @Test
    public void testRadixSort() {
        String[] strs = {"123", "101", "231", "872", "823", "821"};
        RadixSort.sort(strs);
        assertArrayEquals(new String[]{"101", "123", "231", "821", "823", "872"}, strs);
    }
}
