package com.foxtian.structure.c05_queue.exec;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/12 23:18
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}