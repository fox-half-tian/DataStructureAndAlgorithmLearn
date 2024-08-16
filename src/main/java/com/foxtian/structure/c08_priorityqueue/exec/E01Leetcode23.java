package com.foxtian.structure.c08_priorityqueue.exec;

/**
 * Description: <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 23:42
 * @Version 1.0
 */
public class E01Leetcode23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        MinHeap heap = new MinHeap(lists.length);
        // 将链表的头节点加入到小顶堆
        for (ListNode h : lists) {
            if (h != null) {
                heap.offer(h);
            }
        }

        ListNode sentinel = new ListNode();
        ListNode p = sentinel;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
            p.next = minNode;
            p = p.next;
        }

        return sentinel.next;
    }

}


