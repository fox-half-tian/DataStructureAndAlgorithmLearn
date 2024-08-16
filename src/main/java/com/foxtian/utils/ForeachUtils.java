package com.foxtian.utils;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 20:12
 * @Version 1.0
 */
public class ForeachUtils {

    private final static String delimiter = ", ";
    private final static String prefix = "";
    private final static String suffix = "";

    public static <E> String getStrByIterator(Iterable<E> iterable) {
        return getStrByIterator(iterable, delimiter, prefix, suffix);
    }

    public static <E> String getStrByIterator(Iterable<E> iterable, String delimiter) {
        return getStrByIterator(iterable, delimiter, prefix, suffix);
    }

    public static <E> String getStrByIterator(Iterable<E> iterable, String delimiter, String prefix, String suffix) {
        StringJoiner joiner = new StringJoiner(delimiter, prefix, suffix);
        for (E e : iterable) {
            joiner.add(e.toString());
        }
        return joiner.toString();
    }
}
