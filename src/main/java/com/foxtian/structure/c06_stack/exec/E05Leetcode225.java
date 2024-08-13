package com.foxtian.structure.c06_stack.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/">225. 用队列实现栈</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 21:59
 * @Version 1.0
 */
public class E05Leetcode225 {
    class MyStack {

        private LinkedList<Integer> queue = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            while (size > 0) {
                queue.offer(queue.poll());
                size--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    @Test
    public void testMyStack() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.pop());
        assertFalse(myStack.empty());
        assertEquals(1, myStack.pop());
        assertTrue(myStack.empty());
    }
}
