package com.foxtian.doclearn;

import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/12 18:38
 * @Version 1.0
 */
public class Person {
    public static Person person = new Person();

    static {
        System.out.println("静态代码块执行");
    }

    Person() {
        System.out.println("构造器执行");
    }

    public static void main(String[] args) {
        int[] person = new int[10];
        person[1] = 10;
    }

    class B {

    }
}

class B {
    public static void main(String[] args) {
        System.out.println(new B().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            spread(chars, i, i);
            spread(chars, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    int left;
    int right;

    private void spread(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length
                && chars[left] == chars[right]) {
            left--;
            right++;
        }

        if (left < 0 || right >= chars.length || chars[left] != chars[right]) {
            left++;
            right--;
        }

        if (this.right - this.left < right - left) {
            this.left = left;
            this.right = right;
        }
    }
}

