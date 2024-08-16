package com.foxtian.structure.c09_blockqueue;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 单锁实现阻塞队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 19:54
 * @Version 1.0
 */
public class BlockingQueueImpl<E> implements BlockingQueue<E>, Iterable<E> {

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public BlockingQueueImpl(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition headWaits = lock.newCondition();
    private final Condition tailWaits = lock.newCondition();

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @param e
     * @param timeout 最大等待时间，单位 ms
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (t <= 0) {
                    return false;
                }
                // awaitNanos(long nanosTimeout) 的返回值剩余时间
                t = tailWaits.awaitNanos(t);
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int size = BlockingQueueImpl.this.size;
            private int p = head;

            @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public E next() {
                E value = array[p];
                if (++p == array.length) {
                    p = 0;
                }
                size--;
                return value;
            }
        };
    }
}
