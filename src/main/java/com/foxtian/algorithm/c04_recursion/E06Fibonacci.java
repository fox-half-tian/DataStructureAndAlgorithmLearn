package com.foxtian.algorithm.c04_recursion;

import com.foxtian.utils.StopWatch;

/**
 * Description: 递归斐波那契第 n 项
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 18:29
 * @Version 1.0
 */
public class E06Fibonacci {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
        Thread t1 = new Thread(() -> {
            sw.start("f1");
            long v1 = f1(50);
            sw.stop("f1");
            System.out.println("v = " + v1 + ", 耗时 " + sw.elapsedMilliseconds("f1") + " ms");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            sw.start("f2");
            long[] cache = new long[50 + 1];
            cache[1] = 1;
            long v2 = f2(50, cache);
            sw.stop("f2");
            System.out.println("v = " + v2 + ", 耗时 " + sw.elapsedMilliseconds("f2") + " ms");
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("end...");

        /*
            输出结果：
            v = 12586269025, 耗时 0 ms
            v = 12586269025, 耗时 35759 ms
            end...
         */
    }

    public static long f1(int n) {
        if (n <= 1) {
            return n;
        }

        long x = f1(n - 1);
        long y = f1(n - 2);
        return x + y;
    }

    /**
     * 记忆法/备忘录
     *
     * @param n
     * @param cache
     * @return
     */
    public static long f2(int n, long[] cache) {
        if (cache[n] != 0 || n == 0) {
            return cache[n];
        }
        long s = f2(n - 1, cache) + f2(n - 2, cache);
        cache[n] = s;
        return s;
    }
}
