package com.foxtian.structure.c03_linkedlist.exec;

import java.util.LinkedList;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E03Leetcode19 {
    // 方法一：两次遍历
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int count = getNodeCount(head);
        int no = count - n;
        if (no == 0) {
            return head.next;
        }
        ListNode node = head;
        while (no > 1) {
            node = node.next;
            no--;
        }
        node.next = node.next.next;
        return head;
    }

    public static int getNodeCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // 方法二：栈
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (n > 0) {
            stack.pop();
            n--;
        }
        if (stack.isEmpty()) {
            return head.next;
        }
        ListNode prev = stack.pop();
        prev.next = prev.next.next;

        return head;
    }

    // 方法三：递归
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        int no = recursion(head, n);
        if (no == n) {
            return head.next;
        }
        return head;
    }

    // 方法四：递归+哨兵节点
    public static ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        recursion(sentinel, n);
        return sentinel.next;
    }

    public static int recursion(ListNode node, int n) {
        if (node == null) {
            return 0;
        }

        int no = recursion(node.next, n);
        if (no == n) {
            node.next = node.next.next;
        }

        return no + 1;
    }

    // 方法五：快慢指针
    public static ListNode removeNthFromEnd5(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel;
        while (n >= 0) {
            p2 = p2.next;
            n--;
        }

        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        print(node1);
        ListNode newHead = removeNthFromEnd5(node1, 2);
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
