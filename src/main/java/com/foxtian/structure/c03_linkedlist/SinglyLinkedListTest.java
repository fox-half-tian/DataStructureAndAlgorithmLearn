package com.foxtian.structure.c03_linkedlist;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/4 13:43
 * @Version 1.0
 */
public class SinglyLinkedListTest {
    /**
     * 测试添加元素到链表首部 {@link SinglyLinkedList#addFirst(int)}
     * <p>
     * 三种遍历方式
     *     <ol>
     *         <li>while {@link SinglyLinkedList#foreach1(Consumer)}</li>
     *         <li>for {@link SinglyLinkedList#foreach2(Consumer)}</li>
     *         <li>iterator {@link SinglyLinkedList#iterator()}</li>
     *     </ol>
     *
     * </p>
     */
    @Test
    public void testAddFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.foreach1(System.out::println);
        System.out.println("-----------------------------");
        list.foreach2(System.out::println);
        System.out.println("-----------------------------");
        for (Integer value : list) {
            System.out.println(value);
        }

    }

    /**
     * 测试添加元素到链表首部 {@link SinglyLinkedList#addLast(int)}
     */
    @Test
    public void testAddLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.foreach1(System.out::println);
    }

    /**
     * 测试添加元素到链表首部 {@link SinglyLinkedList#get(int)}
     */
    @Test
    public void testGet() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        assert 1 == list.get(0);
        assert 2 == list.get(1);
        assert 3 == list.get(2);
        assert 4 == list.get(3);
    }

    /**
     * 测试添加元素到链表首部 {@link SinglyLinkedList#insert(int, int)}
     */
    @Test
    public void testInsert() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2, 5);
        list.insert(0, 6);

        assert 6 == list.get(0);
        assert 1 == list.get(1);
        assert 2 == list.get(2);
        assert 5 == list.get(3);
        assert 3 == list.get(4);
        assert 4 == list.get(5);
    }

    /**
     * 测试删除链表头节点 {@link SinglyLinkedList#removeFirst()}
     */
    @Test
    public void testRemoveFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();

        assert 2 == list.get(0);
        assert 3 == list.get(1);
        assert 4 == list.get(2);

        list.removeFirst();
        list.removeFirst();

        assert 4 == list.get(0);
    }

    /**
     * 测试删除链表头节点 {@link SinglyLinkedList#remove(int)}
     */
    @Test
    public void testRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.remove(2);
        list.remove(0);

        assert 2 == list.get(0);
        assert 4 == list.get(1);
    }
}
