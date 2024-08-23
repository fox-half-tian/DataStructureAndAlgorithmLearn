package com.foxtian.algorithm.c19_greedy.exec;

import java.util.Arrays;

/**
 * Description: <a href="https://leetcode.cn/problems/non-overlapping-intervals/">435. 无重叠区间</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/23 23:02
 * @Version 1.0
 */
public class E03Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照每个一维数组的第二个元素进行从小到大排序
        Arrays.sort(intervals, (arr1, arr2) -> arr1[1] - arr2[1]);
        // 上一次的右边界
        int lastEnd = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            // 当前区间的左边界大于等于上一轮选择的区间左边界，则无重叠
            if (intervals[i][0] >= lastEnd) {
                lastEnd = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
}
