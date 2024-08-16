package com.foxtian.structure.c10_heap.exec;

import com.foxtian.structure.c10_heap.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/">215. 数组中的第K个最大元素</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 23:13
 * @Version 1.0
 */
public class E02Leetcode215 {
    public static int findKthLargest1(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        return queue.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        // 小顶堆
        MinHeap queue = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.replace(nums[i]);
            }
        }

        return queue.peek();
    }

    @Test
    public void testFindKthLargest1() {
        assertEquals(5, findKthLargest1(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, findKthLargest1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void testFindKthLargest2() {
        assertEquals(5, findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
