package com.foxtian.structure.c03_linkedlist.exec;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/5 23:14
 * @Version 1.0
 */
 public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }