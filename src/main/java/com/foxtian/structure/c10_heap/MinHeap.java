package com.foxtian.structure.c10_heap;

/**
 * Description: 小顶堆
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 23:45
 * @Version 1.0
 */
public class MinHeap {
    private final int[] array;

    private int size;

    public MinHeap(int capacity) {
        this.array = new int[capacity];
    }

    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    /**
     * 建堆
     */
    public void heapify() {
        for (int i = (size - 1) >> 1; i >= 0; i--) {
            down(i);
        }
    }

    private void down(int parent) {
        int min = parent;
        int left = (parent << 1) + 1;
        int right = left + 1;

        if (left < size && array[min] > array[left]) {
            min = left;
        }
        if (right < size && array[min] > array[right]) {
            min = right;
        }

        if (min != parent) {
            swap(min, parent);
            down(min);
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

    public boolean offer(int offered) {
        if (isFull()) {
            return false;
        }

        up(offered);
        return true;
    }

    private void up(int offered) {
        int child = size++;
        int parent = (child - 1) >> 1;
        while (child > 0 && offered < array[parent]) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) >> 1;
        }
        array[child] = offered;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("堆空");
        }

        return array[0];
    }

    public int poll() {
        // if (isEmpty()) {
        //     throw new RuntimeException("堆空");
        // }
        //
        // swap(0, --size);
        // down(0);
        // int removed = array[size];
        // // array[size] = null;
        // return removed;

        return poll(0);
    }

    /**
     * 删除指定位置元素
     *
     * @param index
     * @return
     */
    public int poll(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("index[" + index + "] must < size[" + size + "]");
        }

        swap(index, --size);
        down(index);
        int removed = array[size];
        // array[size] = null;
        return removed;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }
}
