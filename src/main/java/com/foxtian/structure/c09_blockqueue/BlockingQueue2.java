package com.foxtian.structure.c09_blockqueue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 双锁实现阻塞队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 19:54
 * @Version 1.0
 */
public class BlockingQueue2<E> implements BlockingQueue<E>, Iterable<E> {

    private final E[] array;
    private int head;
    private int tail;
    private final AtomicInteger size = new AtomicInteger();

    public BlockingQueue2(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    private final ReentrantLock headLock = new ReentrantLock();
    private final Condition headWaits = headLock.newCondition();

    private final ReentrantLock tailLock = new ReentrantLock();
    private final Condition tailWaits = tailLock.newCondition();

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        tailLock.lockInterruptibly();
        // 添加前的元素个数
        int c;
        try {
            // 队列满时等待
            while (isFull()) {
                tailWaits.await();
            }

            // 队列不满则入队
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            c = size.getAndIncrement();
            if (c + 1 <array.length) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }

        if (c == 0) {
            headLock.lockInterruptibly();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
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
        tailLock.lockInterruptibly();
        // 添加前的元素个数
        int c;
        try {
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (t <= 0) {
                    return false;
                }
                t = tailWaits.awaitNanos(t);
            }

            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            c = size.getAndIncrement();

        } finally {
            tailLock.unlock();
        }

        if (c == 0) {
            headLock.lockInterruptibly();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }

        return true;
    }

    @Override
    public E poll() throws InterruptedException {
        headLock.lockInterruptibly();
        E value;
        int c;
        try {
            while (isEmpty()) {
                headWaits.await();
            }

            value = array[head];
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            c = size.getAndDecrement();
            if (c > 1) {
                headWaits.signal();
            }
        } finally {
            headLock.unlock();
        }

        if (c == array.length) {
            tailLock.lockInterruptibly();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int size = BlockingQueue2.this.size.get();
            private int p = head;
            private final int exceptCount = BlockingQueue2.this.size.get();

            @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public E next() {
                if (exceptCount != BlockingQueue2.this.size.get()) {
                    throw new ConcurrentModificationException();
                }
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
