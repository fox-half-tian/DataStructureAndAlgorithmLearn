package com.foxtian.structure.c16_hashtable.exec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/description/">387. 字符串中的第一个唯一字符</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 0:03
 * @Version 1.0
 */
public class E07Leetcode387 {
    // 数组求解
    public int firstUniqChar1(String s) {
        int[] table = new int[26];
        Arrays.fill(table, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 97;
            if (table[idx] == -1) {
                table[idx] = i;
            } else if (table[idx] > -1){
                table[idx] = -2;
            }
        }


        int min = s.length();
        for (int i : table) {
            if (i >= 0 && i < min) {
                min = i;
            }
        }

        return min == s.length() ? -1 : min;
    }

    // 哈希表求解
    public int firstUniqChar2(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = map.computeIfAbsent(chars[i], k -> new ArrayList<>());
            list.add(i);
        }

        int min = chars.length;
        for (List<Integer> values : map.values()) {
            if (values.size() == 1 && values.get(0) < min) {
                min = values.get(0);
            }
        }

        return min == chars.length ? -1 : min;
    }
}
