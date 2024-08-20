package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

/**
 * Description: <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/">701. 二叉搜索树中的插入操作</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/20 21:41
 * @Version 1.0
 */
public class E02Leetcode701 {
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            parent = p;
            if (p.val < val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (parent.val > val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }

    // 递归方式
    public static TreeNode insertIntoBST2(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertIntoBST2(node.left, val);
        } else {
            node.right = insertIntoBST2(node.right, val);
        }

        return node;
    }
}
