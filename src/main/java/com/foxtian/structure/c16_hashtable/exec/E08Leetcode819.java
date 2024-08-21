package com.foxtian.structure.c16_hashtable.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/most-common-word/description/">819. 最常见的单词</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 0:25
 * @Version 1.0
 */
public class E08Leetcode819 {
    public static String mostCommonWord1(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }

        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = paragraph.toCharArray();
        for (char c : chars) {
            if (c < 65) {
                if (builder.length() == 0) {
                    continue;
                }
                String word = builder.toString();
                Integer count = map.get(word);
                if (count == null) {
                    count = 1;
                } else {
                    count = count + 1;
                }
                map.put(word, count);
                builder.setLength(0);
            } else {
                if (c < 91) {
                    c += 32;
                }
                builder.append(c);
            }
        }

        int max = -1;
        String str = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && !set.contains(entry.getKey())) {
                max = entry.getValue();
                str = entry.getKey();
            }
        }

        return str;
    }

    @Test
    public void testMostCommonWord1() {
        assertEquals("ball", mostCommonWord1("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
