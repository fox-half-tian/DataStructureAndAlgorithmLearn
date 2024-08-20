package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

/**
 * Description: <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description/">700. 二叉搜索树中的搜索</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/20 21:52
 * @Version 1.0
 */
public class E03Leetcode700 {
    public static TreeNode searchBST1(TreeNode root, int val) {
        TreeNode p = root;
        while (p != null) {
            if (val < p.val) {
                p = p.left;
            } else if (p.val < val) {
                p = p.right;
            } else {
                break;
            }
        }
        return p;
    }

    public static TreeNode searchBST2(TreeNode node, int val) {
        if(node == null) {
            return null;
        }

        if (val < node.val) {
            return searchBST2(node.left, val);
        } else if (node.val < val) {
            return searchBST2(node.right, val);
        } else {
            return node;
        }
    }
}
