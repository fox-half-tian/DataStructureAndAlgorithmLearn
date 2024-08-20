package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

/**
 * Description: <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">450. 删除二叉搜索树中的节点</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/20 21:23
 * @Version 1.0
 */
public class E01Leetcode450 {

    private TreeNode root;

    public TreeNode deleteNode(TreeNode root, int key) {
        this.root = root;

        // 找到待删除的节点
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            if (key < p.val) {
                parent = p;
                p = p.left;
            } else if (p.val < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }

        if (p == null) {
            return root;
        }

        /*
                    5
                   / \
                  3   6
                 / \   \
                2  4    7
         */
        if (p.left != null && p.right == null) {
            shift(parent, p, p.left);
        } else if (p.left == null && p.right != null || p.left == null) {
            shift(parent, p, p.right);
        } else {
            // 待删除节点的左子树与右子树都存在
            // 找到待删除节点的后继节点
            TreeNode s = p.right;
            TreeNode sParent = null;
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 如果后继节点是待删除节点的右节点，则说明该右节点没有左子树
            if (s == p.right) {
                shift(parent, p, s);
                s.left = p.left;
            } else {
                // 如果并不相邻
                sParent.left = s.right;
                shift(parent, p, s);
                s.left = p.left;
                s.right = p.right;
            }
        }

        return this.root;
    }

    private void shift(TreeNode parent, TreeNode removed, TreeNode child) {
        if (parent == null) {
            this.root = child;
            return;
        }

        if (parent.left == removed) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    // 递归实现
    public TreeNode deleteNode2(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }

        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }

        if (node.left == null) {
            return node.right;
        }

        if (node.right == null) {
            return node.left;
        }

        // 被删除节点有左右两棵子树
        // 找后继节点
        TreeNode s = node.right;
        while (s.left != null) {
            s = s.left;
        }

        s.right = deleteNode(node.right, s.val);
        s.left = node.left;

        return s;
    }
}
