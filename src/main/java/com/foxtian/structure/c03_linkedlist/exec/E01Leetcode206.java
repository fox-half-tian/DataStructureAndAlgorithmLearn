package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/5 23:14
 * @Version 1.0
 */
public class E01Leetcode206 {
    // 方法1
    public static ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            newHead = new ListNode(head.val, newHead);
            head = head.next;
        }
        return newHead;
    }

    // 方法2
    public static ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        ListNode removed;
        while ((removed = list1.removeFirst()) != null) {
            list2.addFirst(removed);
        }
        return list2.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = head.next;
            }
            return first;
        }
    }

    public static ListNode reverseList3(ListNode p) {
        // 返回最后一个节点
        if (p == null || p.next == null) {
            return p;
        }

        ListNode last = reverseList3(p.next);
        p.next.next = p;
        p.next = null;

        return last;
    }

    public static ListNode reverseList4(ListNode p) {
        if (p == null) {
            return null;
        }
        ListNode newHead = p;
        ListNode node;
        while (p.next != null) {
            node = p.next;
            p.next = node.next;
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    public static ListNode reverseList5(ListNode p) {
        ListNode newHead = null;
        while (p != null) {
            ListNode node = p.next;
            p.next = newHead;
            newHead = p;
            p = node;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        print(node1);
        ListNode newHead = reverseList5(node1);
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
