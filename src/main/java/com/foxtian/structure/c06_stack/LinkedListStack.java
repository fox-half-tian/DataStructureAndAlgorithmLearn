package com.foxtian.structure.c06_stack;

import java.util.Iterator;

/**
 * Description: 单向链表头插法实现栈
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 19:45
 * @Version 1.0
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 最大容量
     */
    private final int capacity;

    /**
     * 当前栈中的元素个数
     */
    private int size;

    private final Node<E> sentinel = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }

        sentinel.next = new Node<>(value, sentinel.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = sentinel.next;
        sentinel.next = removed.next;
        size--;
        return removed.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public boolean isEmpty() {
        // return sentinel.next == null;
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != null;
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
