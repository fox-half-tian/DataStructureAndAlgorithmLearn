package com.foxtian.structure.c03_linkedlist;

import java.util.Iterator;

/**
 * Description: 带哨兵的双向链表
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 15:09
 * @Version 1.0
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    private static class Node {
        /**
         * 上一个节点指针
         */
        Node prev;

        /**
         * 值
         */
        int value;

        /**
         * 下一个节点指针
         */
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头哨兵
     */
    private Node head;
    /**
     * 尾哨兵
     */
    private Node tail;

    public DoublyLinkedListSentinel() {
        head = new Node(null, 50, null);
        tail = new Node(null, 50, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 根据索引查找节点
     *
     * @param index
     * @return
     */
    public Node findNode(int index) {
        if (index < -1) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index + 1));
        }
        int i = -1;
        Node p = head;
        while (p != tail && i != index) {
            p = p.next;
        }

        return p == tail ? null : p;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node prev = tail.prev;
        Node inserted = new Node(prev, value, tail);
        prev.next = inserted;
        tail.prev = inserted;
    }

    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", 0));
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
