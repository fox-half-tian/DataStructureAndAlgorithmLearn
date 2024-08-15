package com.foxtian.structure.c08_priorityqueue;


/**
 * Description: 二叉堆实现优先级队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 21:29
 * @Version 1.0
 */
public class PriorityQueue3<E extends Priority> implements Queue<E> {

    private final Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        this.array = new Priority[capacity];
    }

    // O(n)
    @Override
    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }

        int child = size++;
        int parent = (child - 1) >> 1;
        while (child > 0 && offered.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) >> 1;
        }

        array[child] = offered;
        return true;
    }

    // O(1)
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        swap(0, --size);
        Priority removed = array[size];
        array[size] = null;

        // 下沉
        down(0);
        return (E) removed;
    }

    private void down(int parent) {
        int left = (parent << 1) + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[max].priority() < array[left].priority()) {
            max = left;
        }
        if (right < size && array[max].priority() < array[right].priority()) {
            max = right;
        }

        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority p = array[i];
        array[i] = array[j];
        array[j] = p;
    }


    // O(1)
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
