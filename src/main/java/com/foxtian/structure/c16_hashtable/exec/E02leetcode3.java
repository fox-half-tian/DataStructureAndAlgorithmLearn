package com.foxtian.structure.c16_hashtable.exec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 22:31
 * @Version 1.0
 */
public class E02leetcode3 {
    // 哈希表实现
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int maxLen = 0;
        // k-元素值，v-索引位置
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            Integer idx = map.get(c);
            // 不存在
            if (idx == null || idx < begin) {
                int len = end - begin + 1;
                if (maxLen < len) {
                    maxLen = len;
                }
            } else {
                // 已经存在
                begin = idx + 1;
            }
            map.put(c, end);
        }

        return maxLen;
    }

    // 数组实现
    public int lengthOfLongestSubstring2(String s) {
        int begin = 0;
        int maxLen = 0;
        int[] table = new int[128];
        Arrays.fill(table, -1);
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            int idx = table[c];
            // 不存在
            if (idx == -1 || idx < begin) {
                int len = end - begin + 1;
                if (maxLen < len) {
                    maxLen = len;
                }
            } else {
                // 已经存在
                begin = idx + 1;
            }
            table[c] = end;
        }

        return maxLen;
    }
}
