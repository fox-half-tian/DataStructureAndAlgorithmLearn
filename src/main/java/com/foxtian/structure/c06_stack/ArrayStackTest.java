package com.foxtian.structure.c06_stack;

import com.foxtian.utils.ListGenUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 19:56
 * @Version 1.0
 */
public class ArrayStackTest {
    /**
     * 测试 {@link ArrayStack#push(Object)}
     */
    @Test
    public void testPush() {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertFalse(stack.push(4));
        Assertions.assertIterableEquals(ListGenUtils.toList(3, 2, 1), stack);
    }

    /**
     * 测试 {@link ArrayStack#pop()}
     */
    @Test
    public void testPop() {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertNull(stack.pop());
    }
}
