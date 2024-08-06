package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E06Leetcode21 {

    // 方法一：快慢指针
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            int count = 0;
            int val = p2.val;
            while (p2 != null && p2.val == val) {
                p2 = p2.next;
                count++;
            }
            if (count > 1) {
                p1.next = p2;
            } else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }

    // 方法二：递归
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null && node.next.val == head.val) {
            node = node.next;
        }
        if (head != node) {
            return deleteDuplicates2(node.next);
        }
        head.next = deleteDuplicates2(head.next);
        return head;
    }

    // 方法三：三个指针
    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) ;
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node5_2 = new ListNode(5, null);
        ListNode node5_1 = new ListNode(5, node5_2);
        ListNode node4 = new ListNode(4, node5_1);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2_2 = new ListNode(2, node3);
        ListNode node2_1 = new ListNode(2, node2_2);
        ListNode node1 = new ListNode(1, node2_1);

        print(node1);
        ListNode newHead = deleteDuplicates3(node1);
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
