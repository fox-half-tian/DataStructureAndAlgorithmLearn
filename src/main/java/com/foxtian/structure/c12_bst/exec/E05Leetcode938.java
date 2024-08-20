package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

import java.util.LinkedList;

/**
 * Description: <a href="https://leetcode.cn/problems/range-sum-of-bst/description/">938. 二叉搜索树的范围和</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/20 23:27
 * @Version 1.0
 */
public class E05Leetcode938 {
    private int sum;

    // 递归实现
    public int rangeSumBST1(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }

    private void inorder(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        // 如果 node.val < low，则左子树没必要探索
        if (node.val >= low) {
            inorder(node.left, low, high);
            if (node.val <= high) {
                sum += node.val;
            }
        }

        // 如果 node.val > high，则右子树没必要遍历了
        if (node.val <= high) {
            inorder(node.right, low, high);
        }
    }

    // 非递归
    public int rangeSumBST2(TreeNode root, int low, int high) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                if (p.val < low) {
                    p = null;
                } else {
                    p = p.left;
                }
            } else {
                TreeNode pop = stack.pop();
                if (pop.val >= low && pop.val <= high) {
                    sum += pop.val;
                } else if (pop.val > high) {
                    break;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    public int rangeSumBST4(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST4(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST4(root.left, low, high);
        }

        return root.val + rangeSumBST4(root.left, low, high) + rangeSumBST4(root.right, low, high);
    }
}
