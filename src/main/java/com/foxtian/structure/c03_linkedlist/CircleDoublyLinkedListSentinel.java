package com.foxtian.structure.c03_linkedlist;

import java.util.Iterator;

/**
 * Description: 环形双向链表
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 15:43
 * @Version 1.0
 */
public class CircleDoublyLinkedListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node sentinel = new Node(null, 59, null);

    public CircleDoublyLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加到第一个
     *
     * @param value 待添加值
     */
    public void addFirst(int value) {
        Node next = sentinel.next;
        Node added = new Node(sentinel, value, next);
        sentinel.next = added;
        next.prev = added;
    }

    /**
     * 添加到最后一个
     *
     * @param value 待添加值
     */
    public void addLast(int value) {
        Node last = sentinel.next;
        Node added = new Node(last, value, sentinel);
        last.next = added;
        sentinel.prev = added;
    }


    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", 0));
        }
        Node next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", 0));
        }
        Node newLast = removed.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
    }

    /**
     * 根据值删除
     *
     * @param value 目标值
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return;
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
