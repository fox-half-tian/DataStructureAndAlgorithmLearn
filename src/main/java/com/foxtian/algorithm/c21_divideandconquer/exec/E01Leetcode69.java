package com.foxtian.algorithm.c21_divideandconquer.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/sqrtx/description/">69. x 的平方根</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 22:33
 * @Version 1.0
 */
public class E01Leetcode69 {
    class Solution {
        public int mySqrt(int x) {
            if (x <= 1) {
                return x;
            }
        /*
            1   99  50 --> 99 < 2500
            1   49  25 --> 99 < 625
            1   24  12 --> 99 < 144
            1   11  6  --> 99 > 36  记录最近一次比 99 小的是 6
            7   11  9  --> 99 > 81  记录最近一次比 99 小的是 9
            10  11  10 --> 99 > 100
            10  9
         */
            binarySearch(x, 1, x);
            return sqrt;
        }

        int sqrt;

        private void binarySearch(int x, int i, int j) {
            if (i > j) {
                return;
            }

            int m = (i + j) >>> 1;
            int t = x / m;
            if (m > t) {
                binarySearch(x, i, m - 1);
            } else if (m < t) {
                sqrt = m;
                binarySearch(x, m + 1, j);
            } else {
                sqrt = m;
                return;
            }
        }
    }
}
