package com.foxtian.structure.c08_priorityqueue;


/**
 * Description: 无序数组实现优先级队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 21:29
 * @Version 1.0
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    private final Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        this.array = new Priority[capacity];
    }

    // O(1)
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        return true;
    }

    private int selectMax() {
        int max = array[0].priority();
        int index = 0;
        for (int i = 1; i < size; i++) {
            int p = array[i].priority();
            if (max < p) {
                max = p;
                index = i;
            }
        }

        return index;
    }

    // O(n)
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        int max = selectMax();
        Priority e = array[max];
        remove(max);
        return (E) e;
    }

    private void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    // O(n)
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[selectMax()];
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
