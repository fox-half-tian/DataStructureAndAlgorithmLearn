package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E02Leetcode203 {
    public static ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode node = sentinel;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return sentinel.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }

        return s.next;
    }

    // 方法三：递归
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements3(head.next, val);
        }
        head.next = removeElements3(head.next, val);

        return head;
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(3, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        print(node1);
        ListNode newHead = removeElements3(node1, 3);
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
