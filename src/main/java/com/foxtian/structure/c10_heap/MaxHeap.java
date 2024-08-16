package com.foxtian.structure.c10_heap;

import com.sun.glass.ui.Size;

/**
 * Description: 大顶堆
 * 着重掌握 down(int index)、up(Integer offered)、heapify() 这三个方法
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 22:12
 * @Version 1.0
 */
public class MaxHeap {

    private final Integer[] array;

    private int size;

    public MaxHeap(int capacity) {
        this.array = new Integer[capacity];
    }

    public MaxHeap(Integer[] array) {
        this.array = array;
        this.size = array.length;
    }

    /**
     * 建堆步骤
     * 1.找到最后一个非叶子节点
     * 2.从后向前，对每个节点执行下潜
     */
    private void heapify() {
        for (int i = (size - 1) >> 1; i >= 0; i--) {
            down(i);
        }
    }

    private void down(int parent) {
        int left = (parent << 1) + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    /**
     * 删除顶部元素
     *
     * @return
     */
    public Integer poll() {
        return poll(0);
    }

    /**
     * 删除指定位置的元素
     *
     * @return
     */
    public Integer poll(int index) {
        if (index >= size) {
            return null;
        }

        swap(index, array[--size]);
        Integer removed = array[size];
        array[size] = null;
        down(index);
        return removed;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced
     */
    public void replace(Integer replaced) {
        array[0] = replaced;
        down(0);
    }

    public boolean offer(Integer offered) {
        if (isFull()) {
            return false;
        }

        up(offered);
        return true;
    }

    /**
     * 将 offered 上浮（从最后的开始上浮）
     *
     * @param offered
     */
    private void up(Integer offered) {
        int child = size++;
        int parent = (child - 1) >> 1;
        while (child > 0 && offered > array[parent]) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) >> 1;
        }
        array[child] = offered;
    }
}
