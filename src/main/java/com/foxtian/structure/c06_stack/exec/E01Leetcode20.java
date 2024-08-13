package com.foxtian.structure.c06_stack.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Description: <a href="https://leetcode.cn/problems/valid-parentheses/description/">20. 有效的括号</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 20:26
 * @Version 1.0
 */
public class E01Leetcode20 {

    // 方法一
    public static boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popC = stack.pop();
                if (popC != getMatchChar(aChar)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static char getMatchChar(char aChar) {
        switch (aChar) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new RuntimeException();
        }
    }

    // 方法二
    public static boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != aChar) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid1() {
        Assertions.assertTrue(isValid1("([{}])"));
        Assertions.assertTrue(isValid1("()[]{}"));
        Assertions.assertTrue(isValid1("()"));

        Assertions.assertFalse(isValid1("[)"));
        Assertions.assertFalse(isValid1(")("));
        Assertions.assertFalse(isValid1("([)]"));
        Assertions.assertFalse(isValid1("("));
        Assertions.assertFalse(isValid1("]"));
    }

    @Test
    public void testIsValid2() {
        Assertions.assertTrue(isValid2("([{}])"));
        Assertions.assertTrue(isValid2("()[]{}"));
        Assertions.assertTrue(isValid2("()"));

        Assertions.assertFalse(isValid2("[)"));
        Assertions.assertFalse(isValid2(")("));
        Assertions.assertFalse(isValid2("([)]"));
        Assertions.assertFalse(isValid2("("));
        Assertions.assertFalse(isValid2("]"));
    }
}
