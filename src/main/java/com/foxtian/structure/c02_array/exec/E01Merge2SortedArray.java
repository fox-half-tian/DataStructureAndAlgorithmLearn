package com.foxtian.structure.c02_array.exec;

import com.foxtian.utils.ArrayShowUtils;

/**
 * Description: 力扣 88 题改
 *
 * @Author 狐狸半面添
 * @Create 2024/8/7 23:22
 * @Version 1.0
 */
public class E01Merge2SortedArray {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 6, 2, 4, 10, 11};
        int[] a2 = new int[a1.length];
        merge2(a1, 0, 2, 3, a1.length - 1, a2);
        System.out.println(ArrayShowUtils.getIntSingleArrayStr(a2));
    }

    public static void merge2(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = 0;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] <= a1[j]) {
                a2[k++] = a1[i++];
            }else {
                a2[k++] = a1[j++];
            }
        }

        if (i <= iEnd) {
            while (i <= iEnd) {
                a2[k++] = a1[i++];
            }
        }else {
            while (j <= iEnd) {
                a2[k++] = a1[j++];
            }
        }
    }

    public static void merge1(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k) {
        if (i > iEnd) {
            while (j <= jEnd) {
                a2[k++] = a1[j++];
            }
            return;
        }

        if (j > jEnd) {
            while (i <= iEnd) {
                a2[k++] = a2[i++];
            }
            return;
        }

        if (a1[i] <= a1[j]) {
            a2[k++] = a1[i++];
        } else {
            a2[k++] = a1[j++];
        }
        merge1(a1, i, iEnd, j, jEnd, a2, k);
    }
}
