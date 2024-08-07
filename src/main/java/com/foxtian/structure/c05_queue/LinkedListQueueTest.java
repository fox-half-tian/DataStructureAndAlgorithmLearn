package com.foxtian.structure.c05_queue;

import com.foxtian.utils.ListGenUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/8 0:23
 * @Version 1.0
 */
public class LinkedListQueueTest {
    /**
     * 测试加入到队列尾部 {@link LinkedListQueue#offer(Object)}
     */
    @Test
    public void testOffer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        Assertions.assertIterableEquals(ListGenUtils.toList(1, 2, 3, 4, 5), queue);
    }

    /**
     * 测试获取队列头部元素值（不删除） {@link LinkedListQueue#peek()}
     */
    @Test
    public void testPeek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        Assertions.assertNull(queue.peek());

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Assertions.assertEquals(1, queue.peek());

        queue.offer(4);
        queue.offer(5);

        Assertions.assertEquals(1, queue.peek());
    }

    /**
     * 测试获取队列头部元素值（删除） {@link LinkedListQueue#poll()}
     */
    @Test
    public void testPoll() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        Assertions.assertNull(queue.poll());

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Assertions.assertEquals(1, queue.poll());

        queue.offer(4);
        queue.offer(5);

        Assertions.assertEquals(2, queue.poll());
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertEquals(4, queue.poll());
        Assertions.assertEquals(5, queue.poll());
        Assertions.assertNull(queue.poll());
    }

    /**
     * 测试获取队列头部元素值（删除）添加容量限制规则 {@link LinkedListQueue#poll()}
     */
    @Test
    public void testPollWithCapacity() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Assertions.assertFalse(queue.offer(4));

        Assertions.assertEquals(1, queue.poll());
        queue.offer(4);

        Assertions.assertIterableEquals(ListGenUtils.toList(2, 3, 4), queue);
    }
}
