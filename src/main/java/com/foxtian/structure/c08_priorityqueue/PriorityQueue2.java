package com.foxtian.structure.c08_priorityqueue;


/**
 * Description: 有序数组实现优先级队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 21:29
 * @Version 1.0
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    private final Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        this.array = new Priority[capacity];
    }

    // O(n) 插入排序的思想
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }

        int i = size - 1;
        int p = value.priority();
        while (i >= 0) {
            if (array[i].priority() >= p) {
                array[i + 1] = array[i];
            } else {
                break;
            }
            i--;
        }
        array[i + 1] = value;
        size++;
        return true;
    }

    // O(1)
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        Priority e = array[--size];
        array[size] = null;
        return (E) e;
    }

    // O(1)
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
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
