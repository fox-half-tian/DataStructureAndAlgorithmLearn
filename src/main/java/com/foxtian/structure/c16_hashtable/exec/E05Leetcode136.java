package com.foxtian.structure.c16_hashtable.exec;

import java.util.HashSet;

/**
 * Description: <a href="https://leetcode.cn/problems/single-number/description/">136. 只出现一次的数字</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 23:54
 * @Version 1.0
 */
public class E05Leetcode136 {
    // 哈希表
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }

        for (Integer v : set) {
            return v;
        }

        return -1;
    }

    // 异或
    public int singleNumber2(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        return k;
    }
}
