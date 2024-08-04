package com.foxtian.algorithm.c01_binarysearch;

import com.foxtian.utils.ArrayShowUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/7/30 23:42
 * @Version 1.0
 */
public class TestBinarySearch {
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

    /**
     * {@link BinarySearch#binarySearchBalance(int[], int)} 二分查找平衡版测试，左闭右开区间
     */
    @Test
    public void binarySearchBalanceTest() {
        int[] arr = {2, 3, 6, 8, 11, 22};
        assert 0 == BinarySearch.binarySearchPlus2(arr, arr[0]); // ✅
        assert 1 == BinarySearch.binarySearchPlus2(arr, arr[1]); // ✅
        assert 2 == BinarySearch.binarySearchPlus2(arr, arr[2]); // ✅
        assert 3 == BinarySearch.binarySearchPlus2(arr, arr[3]); // ✅
        assert 4 == BinarySearch.binarySearchPlus2(arr, arr[4]); // ✅
        assert 5 == BinarySearch.binarySearchPlus2(arr, arr[5]); // ✅
        assert -1 == BinarySearch.binarySearchPlus2(arr, 1000); // ✅
    }

    /**
     * 测试实现二分查找目标值，不存在则插入
     */
    @Test
    public void binarySearchInsert() {
        int[] arr = {2, 5, 8};
        int target = 4;
        int index = Arrays.binarySearch(arr, target);

        // 说明需要插入
        if (index < 0) {
            // 插入点索引
            index = -(index + 1);
            int[] newArr = new int[arr.length + 1];
            System.arraycopy(arr, 0, newArr, 0, index);
            newArr[index] = target;
            System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
            System.out.println(ArrayShowUtils.getIntSingleArrayStr(newArr));
        }
    }

    /**
     * {@link BinarySearch#binarySearchLeftmost1(int[], int)} 二分查找 Leftmost 测试
     */
    @Test
    public void binarySearchLeftmost1Test() {
        int[] arr = {1, 2, 4, 4, 4, 5, 6, 6, 7};
        assert 0 == BinarySearch.binarySearchLeftmost1(arr, arr[0]);
        assert 1 == BinarySearch.binarySearchLeftmost1(arr, arr[1]);
        assert 2 == BinarySearch.binarySearchLeftmost1(arr, arr[2]);
        assert 2 == BinarySearch.binarySearchLeftmost1(arr, arr[3]);
        assert 2 == BinarySearch.binarySearchLeftmost1(arr, arr[4]);
        assert 5 == BinarySearch.binarySearchLeftmost1(arr, arr[5]);
        assert 6 == BinarySearch.binarySearchLeftmost1(arr, arr[6]);
        assert 6 == BinarySearch.binarySearchLeftmost1(arr, arr[7]);
        assert 8 == BinarySearch.binarySearchLeftmost1(arr, arr[8]);

        assert -1 == BinarySearch.binarySearchLeftmost1(arr, 3);
        assert -1 == BinarySearch.binarySearchLeftmost1(arr, 9);
        assert -1 == BinarySearch.binarySearchLeftmost1(arr, 0);
    }

    /**
     * {@link BinarySearch#binarySearchRightmost1(int[], int)} 二分查找 Rightmost 测试
     */
    @Test
    public void binarySearchRightmost1Test() {
        int[] arr = {1, 2, 4, 4, 4, 5, 6, 6, 7};
        assert 0 == BinarySearch.binarySearchRightmost1(arr, arr[0]);
        assert 1 == BinarySearch.binarySearchRightmost1(arr, arr[1]);
        assert 4 == BinarySearch.binarySearchRightmost1(arr, arr[2]);
        assert 4 == BinarySearch.binarySearchRightmost1(arr, arr[3]);
        assert 4 == BinarySearch.binarySearchRightmost1(arr, arr[4]);
        assert 5 == BinarySearch.binarySearchRightmost1(arr, arr[5]);
        assert 7 == BinarySearch.binarySearchRightmost1(arr, arr[6]);
        assert 7 == BinarySearch.binarySearchRightmost1(arr, arr[7]);
        assert 8 == BinarySearch.binarySearchRightmost1(arr, arr[8]);

        assert -1 == BinarySearch.binarySearchRightmost1(arr, 3);
        assert -1 == BinarySearch.binarySearchRightmost1(arr, 9);
        assert -1 == BinarySearch.binarySearchRightmost1(arr, 0);
    }

    /**
     * {@link BinarySearch#binarySearchLeftmost2(int[], int)} 二分查找 Leftmost 测试
     */
    @Test
    public void binarySearchLeftmost2Test() {
        int[] arr = {1, 2, 4, 4, 4, 5, 6, 6, 7};
        assert 0 == BinarySearch.binarySearchLeftmost2(arr, 0);
        assert 0 == BinarySearch.binarySearchLeftmost2(arr, 1);
        assert 1 == BinarySearch.binarySearchLeftmost2(arr, 2);
        assert 2 == BinarySearch.binarySearchLeftmost2(arr, 3);
        assert 2 == BinarySearch.binarySearchLeftmost2(arr, 4);
        assert 5 == BinarySearch.binarySearchLeftmost2(arr, 5);
        assert 6 == BinarySearch.binarySearchLeftmost2(arr, 6);
        assert 8 == BinarySearch.binarySearchLeftmost2(arr, 7);
        assert 9 == BinarySearch.binarySearchLeftmost2(arr, 8);
        assert 9 == BinarySearch.binarySearchLeftmost2(arr, 9);
    }

    /**
     * {@link BinarySearch#binarySearchRightmost2(int[], int)} 二分查找 Rightmost 测试
     */
    @Test
    public void binarySearchRightmost2Test() {
        int[] arr = {1, 2, 4, 4, 4, 5, 6, 6, 7};
        assert -1 == BinarySearch.binarySearchRightmost2(arr, 0);
        assert 0 == BinarySearch.binarySearchRightmost2(arr, 1);
        assert 1 == BinarySearch.binarySearchRightmost2(arr, 2);
        assert 1 == BinarySearch.binarySearchRightmost2(arr, 3);
        assert 4 == BinarySearch.binarySearchRightmost2(arr, 4);
        assert 5 == BinarySearch.binarySearchRightmost2(arr, 5);
        assert 7 == BinarySearch.binarySearchRightmost2(arr, 6);
        assert 8 == BinarySearch.binarySearchRightmost2(arr, 7);
        assert 8 == BinarySearch.binarySearchRightmost2(arr, 8);
        assert 8 == BinarySearch.binarySearchRightmost2(arr, 9);
    }
}
