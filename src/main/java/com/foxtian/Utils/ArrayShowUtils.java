package com.foxtian.Utils;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/7/30 23:43
 * @Version 1.0
 */
public class ArrayShowUtils {
    /**
     * 一维数组的字符串
     *
     * @param arr
     * @return
     */
    public static String getIntSingleArrayStr(int[] arr) {
        return getIntSingleArrayStr(arr, ", ", null, null);
    }

    /**
     * 一维数组的字符串
     *
     * @param arr
     * @return
     */
    public static String getIntSingleArrayStr(int[] arr, String separator, String prefix, String suffix) {
        if (arr == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        if (prefix != null) {
            builder.append(prefix);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            builder.append(arr[i]).append(separator);
        }
        builder.append(arr[arr.length - 1]);
        if (suffix != null) {
            builder.append(suffix);
        }
        return builder.toString();
    }
}
