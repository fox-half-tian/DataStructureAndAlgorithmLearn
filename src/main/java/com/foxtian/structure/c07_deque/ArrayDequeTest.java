package com.foxtian.structure.c07_deque;

import com.foxtian.utils.ListGenUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: 测试 {@link ArrayDeque}
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 20:23
 * @Version 1.0
 */
public class ArrayDequeTest {
    @Test
    public void testOffer() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertFalse(deque.offerLast(6));
        assertIterableEquals(ListGenUtils.toList(3, 2, 1, 4, 5), deque);
    }


    @Test
    public void testPoll() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertEquals(3, deque.pollFirst());
        assertEquals(2, deque.pollFirst());
        assertEquals(5, deque.pollLast());
        assertEquals(4, deque.pollLast());
        assertEquals(1, deque.pollLast());
        assertNull(deque.pollLast());
        assertTrue(deque.isEmpty());
    }

}
