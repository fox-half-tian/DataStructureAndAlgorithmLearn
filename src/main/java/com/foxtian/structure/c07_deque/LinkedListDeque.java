package com.foxtian.structure.c07_deque;

import java.util.Iterator;

/**
 * Description: 基于双向循环链表实现双端队列
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 20:07
 * @Version 1.0
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {
    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node<E> sentinel = new Node<>(null, null, null);

    private final int capacity;
    private int size;

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }

        Node<E> oldFirst = sentinel.next;
        Node<E> newFirst = new Node<>(sentinel, e, oldFirst);
        sentinel.next = newFirst;
        oldFirst.prev = newFirst;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }

        Node<E> oldLast = sentinel.prev;
        Node<E> newLast = new Node<>(oldLast, e, sentinel);
        oldLast.next = newLast;
        sentinel.prev = newLast;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removed = sentinel.next;
        sentinel.next = removed.next;
        sentinel.next.prev = sentinel;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removed = sentinel.prev;
        removed.prev.next = sentinel;
        sentinel.prev = removed.prev;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }

        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
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
