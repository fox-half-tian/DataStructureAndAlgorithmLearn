package com.foxtian.structure.c03_linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Description: 单向链表
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 13:29
 * @Version 1.0
 */
public class SinglyLinkedList implements Iterable<Integer> {
    /**
     * 头指针
     */
    private Node head;

    /**
     * 向链表头部添加
     * <p>测试案例查看 {@link SinglyLinkedListTest#testAddFirst()}</p>
     *
     * @param value 待添加值
     */
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void foreach1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void foreach2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 递归遍历
     *
     * @param consumer 待执行操作
     */
    public void foreach3(Consumer<Integer> consumer) {
        recursion(head, consumer);
    }

    public void recursion(Node node, Consumer<Integer> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.value);
        recursion(node.next, consumer);
    }

    /**
     * 查找最后一个节点
     *
     * @return 最后一个节点
     */
    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 向链表尾部插入元素
     *
     * @param value 待插入元素值
     */
    public void addLast(int value) {
        Node last = findLast();
        if (last != null) {
            last.next = new Node(value, null);
        } else {
            head = new Node(value, null);
        }
    }

    private Node findNode(int index) {
        if (index < 0) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }
        int i = 0;
        Node p = head;
        while (p != null && i != index) {
            p = p.next;
            i++;
        }
        return p;
    }

    /**
     * 查找目标索引位置的元素值
     * <p>测试用例查看 {@link SinglyLinkedListTest#testGet()}</p>
     *
     * @param index 索引
     * @return 对应位置节点存储的元素值
     */
    public int get(int index) {
        Node p = findNode(index);
        if (p == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }
        return p.value;
    }

    /**
     * 向索引位置插入
     * <p>测试案例查看 {@link SinglyLinkedListTest#testInsert()}</p>
     *
     * @param index 插入的索引位置
     * @param value 插入值
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        // 找到上一个节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }
        prev.next = new Node(value, prev.next);
    }


    /**
     * 删除链表头节点
     * <p>测试案例查看 {@link SinglyLinkedListTest#testRemoveFirst()}</p>
     */
    public void removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", 0));
        }
        head = head.next;
    }

    /**
     * 删除指定索引位置的节点元素
     * <p>测试案例查看 {@link SinglyLinkedListTest#testRemove()}</p>
     *
     * @param index 待删除节点的索引
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }

        if (prev.next == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法", index));
        }

        prev.next = prev.next.next;
    }

    /**
     * 节点类
     * <p>做成内部类，对外隐藏链表的实现细节</p>
     */
    private static class Node {
        /**
         * 值
         */
        int value;
        /**
         * 下一个节点的指针
         */
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

