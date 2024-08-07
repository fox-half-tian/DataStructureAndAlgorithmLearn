package com.foxtian.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/8 0:25
 * @Version 1.0
 */
public class ListGenUtils {
    public static <E> List<E> toList(E... items) {
        ArrayList<E> list = new ArrayList<>(items.length);
        list.addAll(Arrays.asList(items));
        return list;
    }
}
