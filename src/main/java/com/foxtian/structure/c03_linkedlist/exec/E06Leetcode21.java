package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">21. 合并两个有序链表<a/>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E06Leetcode21 {

    // 方法一
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode p = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }

        return sentinel.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1_4 = new ListNode(4, null);
        ListNode list1_2 = new ListNode(2, list1_4);
        ListNode list1_1 = new ListNode(1, list1_2);

        ListNode list2_4 = new ListNode(4, null);
        ListNode list2_3 = new ListNode(3, list2_4);
        ListNode list2_1 = new ListNode(1, list2_3);

        ListNode newHead = mergeTwoLists2(list1_1, list2_1);
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
