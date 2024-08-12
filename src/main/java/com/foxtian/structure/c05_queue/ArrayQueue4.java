package com.foxtian.structure.c05_queue;

import java.util.Iterator;
import java.util.Map;

/**
 * Description: 环形数组实现队列
 * <p>求模运算：
 * <ul>
 *  <li>如果除数是 2 的 n 次方</li>
 *  <li>那么被除数的后 n 位即为余数</li>
 *  <li>求被除数的后 n 位方法：与 2^n - 1 按位与</li>
 * </ul></p>
 * @Author 狐狸半面添
 * @Create 2024/8/12 21:53
 * @Version 1.0
 */
public class ArrayQueue4<E> implements Queue<E>, Iterable<E> {
    private final E[] array;

    private int head;
    private int tail;

    public ArrayQueue4(int capacity) {
        // 1.抛异常
        // if ((capacity & capacity - 1) != 0) {
        //     throw new IllegalArgumentException("capacity must be 2^n");
        // }

        // 2.改成 2^n
        array = (E[]) new Object[(int)(Math.ceil(Math.log10(capacity) / Math.log10(2)))];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail & (array.length - 1)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int realHeadIndex = head & (array.length - 1);
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
        return array[head & (array.length  - 1)];
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
                E value = array[p & array.length - 1];
                p++;
                return value;
            }
        };
    }
}
