package com.foxtian.structure.c08_priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 21:56
 * @Version 1.0
 */
public class PriorityQueue2Test {
    @Test
    public void testPoll() {
        PriorityQueue2<Priority> queue = new PriorityQueue2<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task1", 3));
        queue.offer(new Entry("task1", 2));
        queue.offer(new Entry("task1", 5));
        queue.offer(new Entry("task1", 1));
        assertFalse(queue.offer(new Entry("task6", 6)));

        assertEquals(5, queue.poll().priority());
        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());
    }
}
