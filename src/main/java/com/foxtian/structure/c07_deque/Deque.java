package com.foxtian.structure.c07_deque;

/**
 * Description: 双端队列接口 double end queue
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 20:04
 * @Version 1.0
 */
public interface Deque<E> {

    /**
     * 向队列头部插入元素
     * @param e
     * @return
     */
    boolean offerFirst(E e);

    /**
     * 向队列尾部插入元素
     * @param e
     * @return
     */
    boolean offerLast(E e);

    /**
     * 从队列头部删除元素
     * @return
     */
    E pollFirst();

    /**
     * 从队列尾部删除元素
     * @return
     */
    E pollLast();

    /**
     * 获取队列头部元素，不删除
     * @return
     */
    E peekFirst();

    /**
     * 获取队列尾部元素，不删除
     * @return
     */
    E peekLast();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列是否已满
     * @return
     */
    boolean isFull();
}
