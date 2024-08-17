package com.foxtian.structure.c11_binarytree;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 22:06
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
