package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.entity.TreeNode;
import com.foxtian.utils.TreeNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/invert-binary-tree/description/">226. 翻转二叉树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 21:39
 * @Version 1.0
 */
public class E07Leetcode226 {
    public static TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode p = node.left;
        node.left = node.right;
        node.right = p;
        dfs(node.left);
        dfs(node.right);
    }

    @Test
    public void testInvertTree() {
        /*
                    1
                   / \
                  2   3
                 / \
                4   5
                   / \
                  7   8

               -->

                    1
                   / \
                  3   2
                     / \
                    5   4
                   / \
                  8   7
         */
        TreeNode root = TreeNodeUtils.arrayToTreeNode(new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 7, 8});
        invertTree(root);
        assertIterableEquals(Arrays.asList(1, 3, 2, null, null, 5, 4, null, null, null, null, 8, 7), Arrays.asList(TreeNodeUtils.treeNodeToArray(root)));
    }
}
