package com.foxtian.structure.c03_linkedlist.exec;

import java.util.LinkedList;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E04Leetcode83 {

    // 方法一：快慢指针
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }

    // 方法二
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    // 方法三：递归
    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head.next;
        while (node != null && head.val == node.val) {
            node = node.next;
        }
        head.next = node;
        deleteDuplicates3(head.next);
        return head;
    }

    // 方法四：递归
    public static ListNode deleteDuplicates4(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null && head.val == head.next.val) {
            return deleteDuplicates4(head.next);
        }
        head.next = deleteDuplicates4(head.next);
        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2_2 = new ListNode(2, node3);
        ListNode node2_1 = new ListNode(2, node2_2);
        ListNode node1 = new ListNode(1, node2_1);

        print(node1);
        ListNode newHead = deleteDuplicates4(node1);
        print(newHead);
    }

    static void print(ListNode head) {
        StringBuilder builder = new StringBuilder("[");
        while (true) {
            builder.append(head.val);
            head = head.next;
            if (head != null) {
                builder.append(", ");
            } else {
                builder.append("]");
                break;
            }
        }

        System.out.println(builder);
    }
}
