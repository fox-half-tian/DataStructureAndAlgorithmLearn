package com.foxtian.structure.c09_blockqueue;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 19:53
 * @Version 1.0
 */
public interface BlockingQueue<E> {
    void offer(E e) throws InterruptedException;

    boolean offer(E e, long timeout) throws InterruptedException;

    E poll() throws InterruptedException;
}
