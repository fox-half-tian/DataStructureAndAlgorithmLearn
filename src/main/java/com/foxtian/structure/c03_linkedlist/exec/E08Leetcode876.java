package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/middle-of-the-linked-list/description/">876. 链表的中间结点<a/>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E08Leetcode876 {

    // 方法一：两次遍历
    public static ListNode middleNode1(ListNode head) {
        int step = getCount(head) >> 1;
        while (step > 0) {
            head = head.next;
            step--;
        }
        return head;
    }

    private static int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // 方法二：快慢指针
    public static ListNode middleNode2(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    static ListNode midNode = null;

    public static ListNode middleNode3(ListNode head) {
        recursion(head, 0);
        return midNode;
    }

    private static int recursion(ListNode node, int count) {
        if (node == null) {
            return (count & 1) == 1 ? count >> 1 : (count >> 1) - 1;
        }

        int n = recursion(node.next, count + 1);
        if (n == 0) {
            midNode = node;
        }
        return n - 1;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        print(node1);
        ListNode newHead = middleNode3(node1);
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
