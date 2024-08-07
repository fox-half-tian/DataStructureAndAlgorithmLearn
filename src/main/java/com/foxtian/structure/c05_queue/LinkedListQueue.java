package com.foxtian.structure.c05_queue;

import java.util.Iterator;

/**
 * Description: 单向环形带哨兵链表实现队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/8 0:15
 * @Version 1.0
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;

    /**
     * 当前节点数
     */
    private int size = 0;

    /**
     * 容量
     */
    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head;
    }

    public LinkedListQueue() {

    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 向队列尾部插入值
     * <p>测试示例查看 {@link LinkedListQueueTest#testOffer()}</p>
     * <p>测试容量示例查看 {@link LinkedListQueueTest#testPollWithCapacity()}</p>
     *
     * @param value 待插入值
     * @return 插入成功返回 true，插入失败返回 false
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        tail.next = new Node<>(value, head);
        tail = tail.next;
        size++;
        return true;
    }

    /**
     * 测试案例查看 {@link LinkedListQueueTest#testPoll()}
     *
     * @return
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removed = head.next;
        head.next = removed.next;
        if (removed == tail) {
            tail = head;
        }
        size--;
        return removed.value;
    }

    /**
     * 测试案例查看 {@link LinkedListQueueTest#testPeek()}
     *
     * @return
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
