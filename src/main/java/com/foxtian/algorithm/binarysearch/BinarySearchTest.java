package com.foxtian.algorithm.binarysearch;

import com.foxtian.Utils.ArrayGenUtils;
import com.foxtian.Utils.ArrayShowUtils;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/7/30 23:42
 * @Version 1.0
 */
public class BinarySearchTest {
    /**
     * {@link BinarySearch#binarySearchBasic(int[], int)} 二分查找基础版
     */
    @Test
    public void binarySearchBasicTest() {
        int[] arr = {1, 3, 6, 8, 11, 23};
        assert 0 == BinarySearch.binarySearchBasic(arr, 1); // ✅
        assert 1 == BinarySearch.binarySearchBasic(arr, 3); // ✅
        assert 2 == BinarySearch.binarySearchBasic(arr, 6); // ✅
        assert 3 == BinarySearch.binarySearchBasic(arr, 8); // ✅
        assert 4 == BinarySearch.binarySearchBasic(arr, 11); // ✅
        assert 5 == BinarySearch.binarySearchBasic(arr, 23); // ✅
        assert -1 == BinarySearch.binarySearchBasic(arr, -1); // ✅
    }

    /**
     * {@link BinarySearch#binarySearchBasic(int[], int)}二分查找基础版数据溢出的问题
     * <p/>
     * <p>binarySearchBasic 问题：i + j 的结果由于超出了 int 能表示的最大值，
     * 导致 (i + j) / 2 的结果不正确</p>
     */
    @Test
    public void binarySearchBasicNumFlowTest() {
        int res = (2 + Integer.MAX_VALUE) / 2;
        System.out.println("res = " + res); // 输出：res = -1073741823
    }

    /**
     * {@link BinarySearch#binarySearchPlus1(int[], int)} 二分查找改进版1测试，解决 {@code (i + j) / 2} 结果不正确的问题
     */
    @Test
    public void binarySearchPlus1Test() {
        int res = (2 + Integer.MAX_VALUE) >>> 2;
        System.out.println("res = " + res); // 输出：res = 536870912

        int[] arr = {2, 3, 6, 8, 11, 13};
        assert 0 == BinarySearch.binarySearchPlus1(arr, arr[0]); // ✅
        assert 1 == BinarySearch.binarySearchPlus1(arr, arr[1]); // ✅
        assert 2 == BinarySearch.binarySearchPlus1(arr, arr[2]); // ✅
        assert 3 == BinarySearch.binarySearchPlus1(arr, arr[3]); // ✅
        assert 4 == BinarySearch.binarySearchPlus1(arr, arr[4]); // ✅
        assert 5 == BinarySearch.binarySearchPlus1(arr, arr[5]); // ✅
        assert -1 == BinarySearch.binarySearchPlus1(arr, 1000); // ✅
    }

    /**
     * {@link BinarySearch#binarySearchPlus2(int[], int)} 二分查找改进版2测试，左闭右开区间
     */
    @Test
    public void binarySearchPlus2Test() {
        int[] arr = {2, 3, 6, 8, 11, 22};
        assert 0 == BinarySearch.binarySearchPlus2(arr, arr[0]); // ✅
        assert 1 == BinarySearch.binarySearchPlus2(arr, arr[1]); // ✅
        assert 2 == BinarySearch.binarySearchPlus2(arr, arr[2]); // ✅
        assert 3 == BinarySearch.binarySearchPlus2(arr, arr[3]); // ✅
        assert 4 == BinarySearch.binarySearchPlus2(arr, arr[4]); // ✅
        assert 5 == BinarySearch.binarySearchPlus2(arr, arr[5]); // ✅
        assert -1 == BinarySearch.binarySearchPlus2(arr, 1000); // ✅
    }
}
