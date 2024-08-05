package com.foxtian.algorithm.c04_recursion;

/**
 * Description: 杨辉三角
 *
 * @Author 狐狸半面添
 * @Create 2024/8/5 22:34
 * @Version 1.0
 */
public class E08PascalTriangle {
    private static int element1(int i, int j) {
        if (i == j || j == 0) {
            return 1;
        }
        return element1(i - 1, j - 1) + element1(i - 1, j);
    }

    private static void printSpace(int n, int i) {
        int num = (n - 1 - i) << 1;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void print1(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element1(i, j));
            }
            System.out.println();
        }
    }

    private static int element2(int i, int j,int[][] triangle) {
        if (triangle[i][j] != 0) {
            return triangle[i][j];
        }
        triangle[i][j] = element1(i - 1, j - 1) + element1(i - 1, j);
        return triangle[i][j];
    }

    /**
     * 优化1 - 使用二维数组记忆法
     * @param n
     */
    public static void print2(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element2(i, j, triangle));
            }
            System.out.println();
        }
    }

    /**
     * 优化2 - 使用一维数组记忆法
     * @param n
     */
    public static void print3(int n) {
        int[] triangle = new int[n];
        triangle[0] = 1;
        for (int i = 0; i < n; i++) {
            // 生成该层数组
            for (int j = i; j >= 1; j--) {
                triangle[j] += triangle[j - 1];
            }

            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", triangle[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // System.out.println(element(4, 2));
        print1(5);
        print2(5);
        print3(5);
    }
}
