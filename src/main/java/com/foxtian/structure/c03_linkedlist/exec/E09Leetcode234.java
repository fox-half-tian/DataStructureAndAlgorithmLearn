package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/palindrome-linked-list/">234. 回文链表<a/>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/6 21:29
 * @Version 1.0
 */
public class E09Leetcode234 {

    // 方法一：暴力破解，但会超出时间限制
    public static boolean isPalindrome1(ListNode head) {
        int length = getCount(head);
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if(getNodeValByIndex(head, i) != getNodeValByIndex(head, j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    private static int getNodeValByIndex(ListNode head, int index) {
        while(index > 0) {
            head = head.next;
            index--;
        }
        return head.val;
    }


    // 方法二：找到中间节点，将原链表的一半节点进行反转，然后进行比较
    public static boolean isPalindrome2(ListNode head) {
        ListNode midNode = getMidNode(head);
        ListNode newHead = reverseList(midNode);
        return compareEqual(newHead, head);
    }

    // 比较两个链表的节点值是否相等（两个链表长度需要相同）
    private static boolean compareEqual(ListNode list1, ListNode list2) {
        while (list1 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    // 反转链表
    private static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    // 查找靠右的中间节点
    private static ListNode getMidNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node1_2 = new ListNode(1, null);
        ListNode node2_2 = new ListNode(2, node1_2);
        ListNode node2_1 = new ListNode(2, node2_2);
        ListNode node1 = new ListNode(1, node2_1);

        print(node1);
        boolean flag = isPalindrome2(node1);
        System.out.println("flag = " + flag);
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
