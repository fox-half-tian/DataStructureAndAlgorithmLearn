package com.foxtian.structure.c09_blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 19:30
 * @Version 1.0
 */
public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail;
    private int size;
    /**
     * 锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();
    /**
     * 条件变量对象，可以看做是一个集合，可以存储多个需要阻塞的线程
     */
    private final Condition tailWaits = lock.newCondition();

    public void offer(String e) throws InterruptedException {
        // lock.lock();
        lock.lockInterruptibly();
        try {
            // while 防止虚假唤醒
            while (isFull()) {
                // 满了该做的事情，offer 线程阻塞
                // 将当前线程加入到 tailWaits，并且让此线程阻塞
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFull() {
        return size == array.length;
    }
}
