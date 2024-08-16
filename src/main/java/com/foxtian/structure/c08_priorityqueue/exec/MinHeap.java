package com.foxtian.structure.c08_priorityqueue.exec;

/**
 * 小顶堆
 */
public class MinHeap {

    /**
     * 数组存储完全二叉树
     * <p>第 i 个节点的孩子节点：</p>
     * <ul>
     *     <li>左孩子：2 * i + 1</li>
     *     <li>右孩子：2 * i + 2</li>
     * </ul>
     */
    ListNode[] array;

    int size;

    public MinHeap(int capacity) {
        this.array = new ListNode[capacity];
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer(ListNode offered) {
        if (isFull()) {
            return false;
        }

        int child = size++;
        int parent = (child - 1) >> 1;
        while (child > 0 && array[parent].val > offered.val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) >> 1;
        }

        array[child] = offered;
        return true;
    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }

        swap(0, --size);
        ListNode removed = array[size];
        array[size] = null;

        down(0);

        return removed;
    }

    private void down(int parent) {
        int min = parent;
        int left = (parent << 1) + 1;
        int right = left + 1;
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int i, int j) {
        ListNode p = array[i];
        array[i] = array[j];
        array[j] = p;
    }

    public ListNode peek() {
        if (isEmpty()) {
            return null;
        }

        return array[0];
    }
}