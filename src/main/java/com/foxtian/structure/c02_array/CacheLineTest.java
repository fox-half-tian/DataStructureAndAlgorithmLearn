package com.foxtian.structure.c02_array;

import com.foxtian.utils.StopWatch;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/3 17:26
 * @Version 1.0
 */
public class CacheLineTest {
    @Test
    public void test1() {
        int rows = 1_000_000;
        int columns = 14;
        int[][] arr = new int[rows][columns];
        StopWatch sw = new StopWatch();
        sw.start("ij");
        ij(arr);
        sw.stop("ij");

        sw.start("ji");
        ji(arr);
        sw.stop("ji");

        System.out.println("ij 耗时：" + sw.elapsedMilliseconds("ij") + "ms");
        System.out.println("ji 耗时：" + sw.elapsedMilliseconds("ji") + "ms");
    }

    public void ij(int[][] arr) {
        long sum = 0L;
        int rows = arr.length;
        int columns = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }

    public void ji(int[][] arr) {
        long sum = 0L;
        int rows = arr.length;
        int columns = arr[0].length;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
