package com.foxtian.algorithm.c22_backtracking.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/sudoku-solver/description/">37. 解数独</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/29 21:51
 * @Version 1.0
 */
public class E09Leetcode37 {
    class Solution {
        public void solveSudoku(char[][] board) {
            // 记录行冲突状态，ca[i][j] 表示在第 i 行中 j 这个数字已经被使用了
            boolean[][] ca = new boolean[9][9];
            // 记录列冲突状态，ca[j][v] 表示在第 j 列中 v 这个数字已经被使用了
            boolean[][] cb = new boolean[9][9];

            // 记录九宫格冲突状态，对于一个 9 * 9 的棋盘，一共有 9 个九宫格
        /*
            对应关系：第 k 个九宫格：k = i/3*3 + j/3
            cc[k][t] 表示第 k 个九宫格 t 这个数字已经被使用了
         */
            boolean[][] cc = new boolean[9][9];

            // 初始化冲突状态
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char ch = board[i][j];
                    if (ch != '.') {
                        // 记录行冲突状态
                        ca[i][ch - '1'] = true;
                        // 记录列冲突状态
                        cb[j][ch - '1'] = true;
                        // 记录九宫格冲突状态
                        cc[i / 3 * 3 + j / 3][ch - '1'] = true;
                    }
                }
            }

            dfs(0, 0, board, ca, cb, cc);
        }

        private boolean dfs(int i, int j, char[][] board, boolean[][] ca, boolean[][] cb, boolean[][] cc) {
            // 找到一个空格的位置
            while (board[i][j] != '.') {
                if (++j >= 9) {
                    j = 0;
                    i++;
                }
                // 如果找到了最后，说明找到了，则返回 true
                if (i >= 9) {
                    return true;
                }
            }

            // 此时 board[i][j] 是一个空位置，就可以进行填空
            // 尝试填入 x 即 1-9
            for (int x = 1; x <= 9; x++) {
                // 检查冲突
                if (ca[i][x - 1] || cb[j][x - 1] || cc[i / 3 * 3 + j / 3][x - 1]) {
                    continue;
                }

                board[i][j] = (char) ('0' + x);
                // 更新记录冲突数组
                ca[i][x - 1] = true;
                cb[j][x - 1] = true;
                cc[i / 3 * 3 + j / 3][x - 1] = true;

                boolean isFind = dfs(i, j, board, ca, cb, cc);
                if (isFind) {
                    return true;
                }

                // 回溯
                ca[i][x - 1] = false;
                cb[j][x - 1] = false;
                cc[i / 3 * 3 + j / 3][x - 1] = false;
                board[i][j] = '.';
            }

            return false;
        }
    }
}
