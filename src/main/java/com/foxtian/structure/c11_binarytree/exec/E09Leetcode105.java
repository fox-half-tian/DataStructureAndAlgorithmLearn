package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.entity.TreeNode;
import com.foxtian.utils.TreeNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">105. 从前序与中序遍历序列构造二叉树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 22:52
 * @Version 1.0
 */
public class E09Leetcode105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public static TreeNode dfs(int[] preorder, int i1, int j1,
                               int[] inorder, int i2, int j2) {
        if (i2 == j2) {
            return new TreeNode(inorder[i2]);
        }
        if (i2 > j2) {
            return null;
        }

        int m = searchIndexByVal(inorder, preorder[i1], i2, j2);
        TreeNode left = dfs(preorder, i1 + 1, i1 + m - i2,
                inorder, i2, m - 1);
        TreeNode right = dfs(preorder, i1 + m - i2 + 1, j1,
                inorder, m + 1, j2);
        return new TreeNode(inorder[m], left, right);
    }

    private static int searchIndexByVal(int[] array, int val, int i, int j) {
        while (i <= j) {
            if (array[i] == val) {
                return i;
            }
            i++;
        }

        return -1;
    }

    @Test
    public void testBuildTree1() {
        /*
                3
               / \
              9   20
                 / \
                15  7
         */
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, TreeNodeUtils.treeNodeToArray(root));
    }

    @Test
    public void testBuildTree2() {
        TreeNode root = buildTree(new int[]{1, 2}, new int[]{2, 1});
        assertArrayEquals(new Integer[]{1, 2}, TreeNodeUtils.treeNodeToArray(root));
    }
}
