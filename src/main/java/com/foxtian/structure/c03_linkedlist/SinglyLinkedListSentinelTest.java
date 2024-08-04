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
public class SinglyLinkedListSentinelTest {
    /**
     * 测试添加元素到链表首部 {@link SinglyLinkedListSentinel#addFirst(int)}
     * <p>
     * 三种遍历方式
     *     <ol>
     *         <li>while {@link SinglyLinkedListSentinel#foreach1(Consumer)}</li>
     *         <li>for {@link SinglyLinkedListSentinel#foreach2(Consumer)}</li>
     *         <li>iterator {@link SinglyLinkedListSentinel#iterator()}</li>
     *     </ol>
     *
     * </p>
     */
    @Test
    public void testAddFirst() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
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
     * 测试添加元素到链表首部 {@link SinglyLinkedListSentinel#addLast(int)}
     */
    @Test
    public void testAddLast() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.foreach1(System.out::println);
    }

    /**
     * 测试添加元素到链表首部 {@link SinglyLinkedListSentinel#get(int)}
     */
    @Test
    public void testGet() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
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
     * 测试添加元素到链表首部 {@link SinglyLinkedListSentinel#insert(int, int)}
     */
    @Test
    public void testInsert() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
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
     * 测试删除链表头节点 {@link SinglyLinkedListSentinel#removeFirst()}
     */
    @Test
    public void testRemoveFirst() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
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
     * 测试删除链表头节点 {@link SinglyLinkedListSentinel#remove(int)}
     */
    @Test
    public void testRemove() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
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
