package com.foxtian.structure.c06_stack.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Description: <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/">150. 逆波兰表达式求值</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 20:50
 * @Version 1.0
 */
public class E02Leetcode150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        Integer second;
        Integer first;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    @Test
    public void testEvalRPN() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Assertions.assertEquals(22, evalRPN(tokens));
    }
}
