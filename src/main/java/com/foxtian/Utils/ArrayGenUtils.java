package com.foxtian.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/7/30 23:35
 * @Version 1.0
 */
public class ArrayGenUtils {
    public static int[] genIntArray() {
        return genIntArray(10, 0, 10000);
    }

    public static int[] genIntArray(int count, int minValue, int maxValue) {
        Random random = new Random();
        int diff = maxValue - minValue;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(diff) + minValue;
        }
        Arrays.sort(arr);
        return arr;
    }
}
