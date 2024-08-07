package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/linked-list-cycle/description/">141. 环形链表<a/>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E10Leetcode141 {
    public static boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node3;

        boolean flag = hasCycle(node1);
        System.out.println("flag = " + flag);
    }

}
