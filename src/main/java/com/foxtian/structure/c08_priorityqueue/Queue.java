package com.foxtian.structure.c08_priorityqueue;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/8 0:09
 * @Version 1.0
 */
public interface Queue<E> {
    /**
     * 向队列尾插入值
     * @param value 待插入值
     * @return 插入成功返回 true，插入失败返回 false
     */
    boolean offer(E value);

    /**
     * 从队列头获取值并移除
     * @return 如果队列非空返回队头值，否则返回 null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return 如果队列非空返回队头值，否则返回 null
     */
    E peek();

    /**
     * 检查队列是否空
     * @return 空返回 true，否则返回 false
     */
    boolean isEmpty();

    /**
     * 检查队列是否已满
     * @return 满返回 true，否则返回 false
     */
    boolean isFull();
}
