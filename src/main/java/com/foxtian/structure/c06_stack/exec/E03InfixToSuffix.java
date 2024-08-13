package com.foxtian.structure.c06_stack.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: 中缀转后缀表达式
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 21:06
 * @Version 1.0
 */
public class E03InfixToSuffix {
    static int priority(char c) {
        switch (c) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("不合法的运算符：" + c);
        }
    }

    static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder(exp.length());
        for (char c : exp.toCharArray()) {
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    // 如果栈顶元素的优先级大于等于当前运算符，则将栈顶元素出栈拼接到 builder
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        builder.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    char popC;
                    while ((popC = stack.pop()) != '(') {
                        builder.append(popC);
                    }
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    @Test
    public void testInfixToSuffix() {
        assertEquals("ab+", infixToSuffix("a+b"));
        assertEquals("ab+c-", infixToSuffix("a+b-c"));
        assertEquals("abc*+", infixToSuffix("a+b*c"));
        assertEquals("ab*c-", infixToSuffix("a*b-c"));

        assertEquals("ab+c*", infixToSuffix("(a+b)*c"));
        assertEquals("abc*+d-e*", infixToSuffix("(a+b*c-d)*e"));
        assertEquals("abc+*", infixToSuffix("a*(b+c)"));
    }
}
