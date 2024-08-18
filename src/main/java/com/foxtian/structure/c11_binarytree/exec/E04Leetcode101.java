package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.structure.c11_binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Description: <a href="https://leetcode.cn/problems/symmetric-tree/description/">101. 对称二叉树</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 20:01
 * @Version 1.0
 */
public class E04Leetcode101 {
    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            }
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

    @Test
    public void testIsSymmetric() {
        /*
                    1
                   / \
                  2   2
                 / \ / \
                3  4 4  3
         */
        TreeNode root1 = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        assertTrue(isSymmetric(root1));

        /*
                    1
                   / \
                  2   2
                   \   \
                   3    3
         */
        TreeNode root2 = new TreeNode(
                1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        assertFalse(isSymmetric(root2));
    }
}
