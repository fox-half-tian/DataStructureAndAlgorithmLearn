package com.foxtian.algorithm.c21_divideandconquer.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/">395. 至少有 K 个重复字符的最长子串</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/28 23:40
 * @Version 1.0
 */
public class E02Leetcode395 {
    class Solution {

        int maxLen = 0;

        public int longestSubstring(String s, int k) {
            search(s.toCharArray(), 0, s.length() - 1, k);
            return maxLen;
        }

        public void search(char[] chars, int left, int right, int k) {
            int len = right - left + 1;
            // 整个子串长度小于 k 则直接排除
            if (len < k) {
                return;
            }

            // 统计出现次数
            int[] table = new int[26];
            int i = left;
            while (i <= right) {
                table[chars[i] - 97]++;
                i++;
            }

            // 如果所有字符出现次数都大于 k，则可以进行统计
            boolean success = true;
            for (int count : table) {
                if (count != 0 && count < k) {
                    success = false;
                    break;
                }
            }
            if (success) {
                maxLen = Integer.max(len, maxLen);
                return;
            }

            // 切分字符串
            i = left;
            int start = left;
            while (i <= right) {
                if (table[chars[i] - 97] < k) {
                    search(chars, start, i - 1, k);
                    while (i <= right && table[chars[i] - 97] < k) {
                        i++;
                    }
                    start = i;
                }
                i++;
            }
            search(chars, start, i - 1, k);
        }
    }
}
