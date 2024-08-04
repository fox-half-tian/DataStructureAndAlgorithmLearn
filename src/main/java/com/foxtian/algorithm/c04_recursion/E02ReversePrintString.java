package com.foxtian.algorithm.c04_recursion;

/**
 * Description: 递归反向打印字符串
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 17:25
 * @Version 1.0
 */
public class E02ReversePrintString {
    public static void reversePrint(String s) {
        recursion(s, 0);
    }

    private static void recursion(String s, int index) {
        if (s.length() == index){
            return;
        }
        recursion(s, index + 1);
        System.out.print(s.charAt(index));
    }

    public static void main(String[] args) {
        reversePrint("hello");
    }
}
