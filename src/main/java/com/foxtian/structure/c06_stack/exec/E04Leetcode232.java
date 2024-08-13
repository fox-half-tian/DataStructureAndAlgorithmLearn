package com.foxtian.structure.c06_stack.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">232. 用栈实现队列</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 21:44
 * @Version 1.0
 */
public class E04Leetcode232 {
    class MyQueue {

        private final LinkedList<Integer> stack1 = new LinkedList<>();
        private final LinkedList<Integer> stack2 = new LinkedList<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException();
            }
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (empty()) {
                throw new RuntimeException();
            }
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    @Test
    public void testMyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, myQueue.peek()); // return 1
        assertEquals(1, myQueue.pop()); // return 1, queue is [2]
        assertFalse(myQueue.empty()); // return false
        assertEquals(2, myQueue.pop()); // return 2, queue is []
        assertTrue(myQueue.empty()); // return true
    }
}
