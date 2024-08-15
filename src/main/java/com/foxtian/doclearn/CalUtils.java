package com.foxtian.doclearn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 通用计算工具类
 *
 * @author 狐狸半面添
 * @since 1.0
 */
public class CalUtils {

    public static void main(String[] args) {
        int[] ints = new int[Integer.MAX_VALUE];
    }
}

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        int[][] dirs = {
                {-1, -1},
                {0, -1},
                {1, -1},
                {-1, 0},
                {0, 0},
                {1, 0},
                {-1, 1},
                {0, 1},
                {1, 1}
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int sum = 0;
                for (int k = 0; k < dirs.length; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        count++;
                        sum += img[x][y];
                    }
                }

                res[i][j] = sum / count;
            }
        }

        return res;
    }
}
