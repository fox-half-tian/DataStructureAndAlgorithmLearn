package com.foxtian.structure.c06_stack;

import java.util.Iterator;

/**
 * Description: 数组实现栈
 *
 * @Author 狐狸半面添
 * @Create 2024/8/13 20:13
 * @Version 1.0
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E>{
    private E[] array;

    /**
     * 栈顶指针
     */
    private int top;

    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = array[--top];
        array[top] = null;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = top;

            @Override
            public boolean hasNext() {
                return p != 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
