package com.foxtian.structure.c16_hashtable.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/valid-anagram/description/">242. 有效的字母异位词</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 23:56
 * @Version 1.0
 */
public class E06Leetcode242 {
    public boolean isAnagram(String s, String t) {
        int[] table = new int[128];
        for (char c : s.toCharArray()) {
            table[c]++;
        }
        for (char c : t.toCharArray()) {
            table[c]--;
        }

        for (int i = 97; i < 123; i++) {
            if (table[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
