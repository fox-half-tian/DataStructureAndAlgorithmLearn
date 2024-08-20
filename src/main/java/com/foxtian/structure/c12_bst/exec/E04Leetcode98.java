package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

import java.util.LinkedList;

/**
 * Description: <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">98. 验证二叉搜索树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/20 21:59
 * @Version 1.0
 */
public class E04Leetcode98 {
    private long val = Long.MIN_VALUE;

    // 递归
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isValidBST1(root.left) && val < root.val) {
            val = root.val;
            return isValidBST1(root.right);
        }

        return false;
    }

    public boolean isValidBST3(TreeNode root) {
            return isValid(root, new KeepPrev());
    }

    // 递归
    public boolean isValid(TreeNode root, KeepPrev prev) {
        if (root == null) {
            return true;
        }

        if (isValid(root.left, prev) && prev.val < root.val) {
            prev.val = root.val;
            return isValid(root.right, prev);
        }

        return false;
    }

    static class KeepPrev {
        long val = Long.MIN_VALUE;
    }

    // 非递归
    public boolean isValidBST2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        long val = Long.MIN_VALUE;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (val < pop.val) {
                    val = pop.val;
                    p = pop.right;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // 上下限方式
    public boolean isValidBST4(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 递归
    public boolean isValid(TreeNode root, long i, long j) {
        if (root == null) {
            return true;
        }

        if (root.val > i && root.val < j) {
            return isValid(root.left, i, root.val) && isValid(root.right, root.val, j);
        } else {
            return false;
        }
    }
}
