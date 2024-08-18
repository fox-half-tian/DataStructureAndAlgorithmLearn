package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.entity.TreeNode;
import com.foxtian.utils.TreeNodeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 23:18
 * @Version 1.0
 */
public class E10Leetcode106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder,0,inorder.length - 1,
                postorder,0,postorder.length -1 );
    }

    private static TreeNode dfs(int[] inorder, int i1, int j1,
                                int[] postorder, int i2, int j2) {
        if (i1 == j1) {
            return new TreeNode(inorder[i1]);
        }
        if (i1 > j1) {
            return null;
        }

        int m = searchIndexByVal(inorder, postorder[j2], i1, j1);
        TreeNode left = dfs(inorder, i1, m - 1,
                postorder, i2, i2 + m - i1 - 1);
        TreeNode right = dfs(inorder, m + 1, j1,
                postorder, i2 + m - i1, j2 - 1);
        return new TreeNode(inorder[m],left,right);
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
        TreeNode root = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, TreeNodeUtils.treeNodeToArray(root));
    }

    @Test
    public void testBuildTree2() {
        TreeNode root = buildTree(new int[]{2, 1}, new int[]{2, 1});
        assertArrayEquals(new Integer[]{1, 2}, TreeNodeUtils.treeNodeToArray(root));
    }
}
