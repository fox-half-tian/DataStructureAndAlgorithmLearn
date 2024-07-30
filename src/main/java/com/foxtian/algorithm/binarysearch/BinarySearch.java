package com.foxtian.algorithm.binarysearch;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/7/29 23:13
 * @Version 1.0
 */
public class BinarySearch {
    /**
     * 二分查找基础版
     * <p/>
     * <p>测试案例查看 {@link BinarySearchTest#binarySearchBasicTest()}</p>
     * <p>数据溢出问题测试案例查看 {@link BinarySearchTest#binarySearchBasicNumFlowTest()}</p>
     *
     * @param arr    待查找的升序数组
     * @param target 待查找的目标值
     * @return 目标值对应索引，如果找不到，返回 {@code -1}
     */
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target < arr[m]) {
                // 目标值在中间值的左侧
                j = m - 1;
            } else if (arr[m] < target) {
                // 目标值在中间值的右侧
                i = m + 1;
            } else {
                // 找到了
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找改动版1，解决 {@code (i + j)} 数据溢出的问题
     * <p/>
     * <p>测试案例查看 {@link BinarySearchTest#binarySearchPlus1Test()}</p>
     *
     * @param arr    待查找的升序数组
     * @param target 待查找的目标值
     * @return 目标值对应索引，如果找不到，返回 {@code -1}
     */
    public static int binarySearchPlus1(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            // 也可以用 int m = i + (j - i) / 2;
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                // 目标值在中间值的左侧，下次应该在左边找，因此缩小右边界
                j = m - 1;
            } else if (arr[m] < target) {
                // 目标值在中间值的右侧，下次应该在右边找，因此缩小左边界
                i = m + 1;
            } else {
                // 找到了
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找改动版2，左闭右开区间
     * <p/>
     * <p>测试案例查看 {@link BinarySearchTest#binarySearchPlus2Test()}</p>
     *
     * @param arr    待查找的升序数组
     * @param target 待查找的目标值
     * @return 目标值对应索引，如果找不到，返回 {@code -1}
     */
    public static int binarySearchPlus2(int[] arr, int target) {
        // 查找范围 [i, j) 的左闭右开区间
        // j 代表右边界，最高能取到 j-1 的位置，而不是 j 位置
        int i = 0, j = arr.length;

        // 如果写成 i <= j，则在 i == j 且 target < arr[m] 的情况下出现死循环
        // 因为当 target < arr[m] 时，会设置 j = m，而 i == j 的前提下 m 就是 j
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                // 右边界，无法取到
                j = m;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                // 找到了
                return m;
            }
        }
        return -1;
    }
}
