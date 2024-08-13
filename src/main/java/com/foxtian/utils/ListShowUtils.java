package com.foxtian.utils;

import java.util.List;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/7/30 23:43
 * @Version 1.0
 */
public class ListShowUtils {
    public static<E> String getListItemsStr(List<E> list) {
        return getListItemsStr(list, ", ", null, null);
    }

    public static <E>String getListItemsStr(List<E> list, String separator, String prefix, String suffix) {
        if (list == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        if (prefix != null) {
            builder.append(prefix);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i).toString()).append(separator);
        }
        builder.append(list.get(list.size() - 1).toString());
        if (suffix != null) {
            builder.append(suffix);
        }
        return builder.toString();
    }
}
