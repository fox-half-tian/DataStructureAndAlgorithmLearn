package com.foxtian.structure.c10_heap.exec;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/">703. 数据流中的第 K 大元素</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 19:58
 * @Version 1.0
 */
public class E03Leetcode703 {
    class KthLargest {
        private final PriorityQueue<Integer> queue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>(k);
            this.k = k;
            for (int i = 0; i < k && i < nums.length; i++) {
                queue.offer(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
                return queue.peek();
            }
            if (val > queue.peek()) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }

    @Test
    public void testKthLargest() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }
}
