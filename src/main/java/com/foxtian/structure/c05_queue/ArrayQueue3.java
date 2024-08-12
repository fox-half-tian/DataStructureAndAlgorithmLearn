package com.foxtian.structure.c05_queue;

import java.util.Iterator;

/**
 * Description: 环形数组实现队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/12 21:53
 * @Version 1.0
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {
    private final E[] array;

    private int head;
    private int tail;

    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int realHeadIndex = (int) (Integer.toUnsignedLong(head)) % array.length;
        E value = array[realHeadIndex];
        array[realHeadIndex] = null;
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[(int) (Integer.toUnsignedLong(head)) % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[(int) (Integer.toUnsignedLong(p)) % array.length];
                p++;
                return value;
            }
        };
    }
}
