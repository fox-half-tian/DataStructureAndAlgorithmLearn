package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

/**
 * Description: <a href="https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/description/">1008. 前序遍历构造二叉搜索树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/20 23:49
 * @Version 1.0
 */
public class E06Leetcode1008 {
    public TreeNode bstFromPreorder1(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    // 分治算法
    private TreeNode dfs(int[] preorder, int i, int j) {
        if (i == j) {
            return new TreeNode(preorder[i]);
        }
        if (i > j) {
            return null;
        }

        int k = i + 1;
        while (k <= j) {
            if (preorder[k] < preorder[i]) {
                k++;
            } else {
                break;
            }
        }
        k--;
        TreeNode left = dfs(preorder, i + 1, k);
        TreeNode right = dfs(preorder, k + 1, j);
        return new TreeNode(preorder[i], left, right);
    }

    public TreeNode bstFromPreorder2(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertNode2(root, preorder[i]);
        }
        return root;
    }

    private void insertNode2(TreeNode root, int val) {
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null)  {
            parent = p;
            if (val < p.val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
    }


    public TreeNode bstFromPreorder3(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertNode3(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insertNode3(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertNode3(node.left, val);
        } else {
            node.right = insertNode3(node.right, val);
        }

        return node;
    }

    public TreeNode bstFromPreorder4(int[] preorder) {
        return insertNode4(preorder, Integer.MAX_VALUE);
    }

    int i = 0;
    private TreeNode insertNode4(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }

        int val = preorder[i];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insertNode4(preorder, val);
        node.right = insertNode4(preorder, max);
        return node;
    }
}
