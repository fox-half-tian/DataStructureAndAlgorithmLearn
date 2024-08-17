package com.foxtian.structure.c10_heap.exec;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/find-median-from-data-stream/description/">295. 数据流的中位数</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 20:54
 * @Version 1.0
 */
public class E04Leetcode295 {
    class MedianFinder1 {

        // 用于存放较小值的大顶堆
        private final Heap left = new Heap(10, true);
        // 用于存放较大值的小顶堆
        private final Heap right = new Heap(10, false);

        public MedianFinder1() {

        }

        public void addNum(int num) {
            // 数量相同，先向右边加入，再将右边最小的加入到左边
            if (left.getSize() == right.getSize()) {
                right.offer(num);
                left.offer(right.poll());
            } else {
                // 数目不相等，先向左边加入，再将左边最大的加入到右边
                left.offer(num);
                right.offer(left.poll());
            }
        }

        public double findMedian() {
            if (left.getSize() == right.getSize()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }

        class Heap {
            private int size;
            private int[] array;
            private final boolean isMaxHeap;

            public Heap(int capacity, boolean isMaxHeap) {
                this.isMaxHeap = isMaxHeap;
                array = new int[capacity];
            }

            public void offer(int offered) {
                if (isFull()) {
                    // 扩容
                    grow();
                }
                up(offered);
            }

            private void grow() {
                int capacity = size + (size >> 1);
                int[] newArray = new int[capacity];
                System.arraycopy(array, 0, newArray, 0, array.length);
                this.array = newArray;
            }

            public void up(int offered) {
                int child = size++;
                int parent = (child - 1) >> 1;
                while (child > 0 &&
                        (isMaxHeap ? offered > array[parent] : offered < array[parent])) {
                    array[child] = array[parent];
                    child = parent;
                    parent = (child - 1) >> 1;
                }

                array[child] = offered;
            }

            public int poll() {
                int removed = array[0];
                swap(0, --size);
                down(0);
                return removed;
            }

            private void down(int parent) {
                int left = (parent << 1) + 1;
                int right = left + 1;
                int index = parent;

                if (left < size &&
                        (isMaxHeap ? array[left] > array[index] : array[left] < array[index])) {
                    index = left;
                }
                if (right < size &&
                        (isMaxHeap ? array[right] > array[index] : array[right] < array[index])) {
                    index = right;
                }

                if (index != parent) {
                    swap(index, parent);
                    down(index);
                }
            }

            private void swap(int i, int j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }

            public int peek() {
                return array[0];
            }

            public int getSize() {
                return this.size;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull() {
                return size == array.length;
            }
        }
    }

    @Test
    public void testMedianFinder1() {
        MedianFinder1 medianFinder = new MedianFinder1();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
    }

    class MedianFinder2 {

        // 用于存放较小值的大顶堆
        private final PriorityQueue<Integer> left = new PriorityQueue<>((n1, n2)->n2 - n1);
        // 用于存放较大值的小顶堆
        private final PriorityQueue<Integer> right = new PriorityQueue<>();

        public MedianFinder2() {

        }

        public void addNum(int num) {
            // 数量相同，先向右边加入，再将右边最小的加入到左边
            if (left.size() == right.size()) {
                right.offer(num);
                left.offer(right.poll());
            } else {
                // 数目不相等，先向左边加入，再将左边最大的加入到右边
                left.offer(num);
                right.offer(left.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }

    @Test
    public void testMedianFinder2() {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
    }
}
