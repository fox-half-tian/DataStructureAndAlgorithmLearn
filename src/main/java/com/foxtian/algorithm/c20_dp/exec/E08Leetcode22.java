package com.foxtian.algorithm.c20_dp.exec;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/generate-parentheses/description/">22. 括号生成</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/25 22:54
 * @Version 1.0
 */
public class E08Leetcode22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String>[] dp = new ArrayList[n + 1];
            dp[0] = new ArrayList<>();
            dp[0].add("");
            dp[1] = new ArrayList<>();
            dp[1].add("()");
            for (int j = 2; j <= n; j++) {
                dp[j] = new ArrayList<>();
                // i 表示包含的括号数
                for (int i = 0; i < j; i++) {
                    // o 表示平级的括号数
                    int o = j - i - 1;
                    for (String iStr : dp[i]) { // dp[i] 为包含的括号的种类
                        for (String oStr : dp[o]) { // dp[o] 为平级的括号的种类
                            dp[j].add("(" + iStr + ")" + oStr);
                        }
                    }
                }
            }

            return dp[n];
        }
    }
}
