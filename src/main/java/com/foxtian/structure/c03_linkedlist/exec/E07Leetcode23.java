package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E07Leetcode23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    private static ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }

        int m = (i + j) >>> 1;
        ListNode list1 = split(lists, i, m);
        ListNode list2 = split(lists, m + 1, j);
        return mergeTwoList(list1, list2);
    }

    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList(list1, list2.next);
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

        ListNode list3_5 = new ListNode(5, null);
        ListNode list3_3 = new ListNode(3, list3_5);
        ListNode list3_2 = new ListNode(2, list3_3);

        ListNode newHead = mergeKLists(new ListNode[]{list1_1, list2_1, list3_2});
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
