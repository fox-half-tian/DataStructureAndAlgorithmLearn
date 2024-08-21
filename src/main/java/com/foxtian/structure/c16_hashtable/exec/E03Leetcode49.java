package com.foxtian.structure.c16_hashtable.exec;

import java.util.*;

/**
 * Description: <a href="https://leetcode.cn/problems/group-anagrams/description/">49. 字母异位词分组</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 23:08
 * @Version 1.0
 */
public class E03Leetcode49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将字符串的字符重新排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }

    static class ArrayKey {
        int[] key = new int[26];

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(key, arrayKey.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }

        public ArrayKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                key[ch - 97]++;
            }
        }
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey key = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
