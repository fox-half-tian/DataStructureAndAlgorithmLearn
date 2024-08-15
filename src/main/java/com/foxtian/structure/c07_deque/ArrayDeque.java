package com.foxtian.structure.c07_deque;

import java.util.Iterator;

/**
 * Description: 循环数组实现双端队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 20:28
 * @Version 1.0
 */
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

    static int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    static int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    private final E[] array;

    int head;
    int tail;

    public ArrayDeque(int capacity) {
        this.array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }

        head = dec(this.head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }

        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }

        E value = array[head];
        array[head] = null;
        head = inc(head, array.length);
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }

        tail = dec(tail, array.length);
        E value = array[tail];
        array[tail] = null;
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }
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
                E value = array[p];
                p = inc(p, array.length);
                return value;
            }
        };
    }
}
