package com.foxtian.algorithm.c22_backtracking.exec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/n-queens/description/">51. N 皇后</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 21:21
 * @Version 1.0
 */
public class E08Leetcode51 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            // 记录列是否发生冲突，即 ca[i] 为 true 表示第 i 列上已经存在了皇后
            boolean[] ca = new boolean[n];

            // 记录左斜线冲突
            // 左斜线的数量为 2 * n - 1
            // 对于左斜线， 同一左斜线上的 i + j 的结果是相同的
            /*
                    0   1   2   3
                 0  0   1   2   3
                 1  1   2   3   4
                 2  2   3   4   5
                 3  3   4   5   6
             */
            // i + j 的结果即对应标记数组的位置 cb[i + j]
            boolean[] cb = new boolean[(n << 1) - 1];

            // 记录右斜线冲突
            // 右斜线的数量为 2 * n - 1
            // 对于右斜线， 同一左斜线上的 i - j 的结果是相同的
            /*
                    0   1   2   3
                 0  0   -1  -2  -3
                 1  1   0   -1  -2
                 2  2   1   0   -1
                 3  3   2   1   0
             */
            // 但是 i - j 可能是负数，不好与标记数组索引位置相对应，因此可以转为 n - 1 - (i - j)
            /*
                    0   1   2   3
                 0  3   4   5   6
                 1  2   3   4   5
                 2  1   2   3   4
                 3  0   1   2   3
             */
            // n - 1 - (i - j) 的结果即对应标记数组的位置 cc[n - 1 - (i - j)]
            boolean[] cc = new boolean[(n << 1) - 1];

            char[][] table = new char[n][n];
            for (char[] t : table) {
                Arrays.fill(t, '.');
            }

            List<List<String>> res = new ArrayList<>();
            dfs(0, n, table, ca, cb, cc, res);
            return res;
        }

        /**
         * @param i     当前需要处理的行
         * @param n     总行数
         * @param table
         * @param ca    记录列冲突
         * @param cb    记录左斜线冲突
         * @param cc    记录右斜线冲突
         * @param res
         */
        private void dfs(int i, int n, char[][] table, boolean[] ca, boolean[] cb, boolean[] cc, List<List<String>> res) {
            // 找到解
            if (i == n) {
                List<String> list = new ArrayList<>(n);
                for (char[] t : table) {
                    list.add(new String(t));
                }
                res.add(list);
                return;
            }

            for (int j = 0; j < n; j++) {
                // 如果有冲突，则跳过对第 i 行第 j 列的访问，继续向后访问第 i 行第 j+1 列
                if (ca[j] || cb[i + j] || cc[n - 1 - (i - j)]) {
                    continue;
                }

                // 第 i 行第 j 列
                table[i][j] = 'Q';
                // 记录列冲突
                ca[j] = true;
                // 记录左斜线冲突
                cb[i + j] = true;
                // 记录右斜线冲突
                cc[n - 1 - (i - j)] = true;

                dfs(i + 1, n, table, ca, cb, cc, res);

                // 回溯
                table[i][j] = '.';
                ca[j] = false;
                cb[i + j] = false;
                cc[n - 1 - (i - j)] = false;
            }
        }
    }
}
