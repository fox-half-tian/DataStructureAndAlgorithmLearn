package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.entity.TreeNode;
import com.foxtian.utils.TreeNodeGenUtils;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/">111. 二叉树的最小深度</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 21:06
 * @Version 1.0
 */
public class E06Leetcode111 {
    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth1(root.left), minDepth1(root.right));
        }

        if (root.left != null) {
            return 1 + minDepth1(root.left);
        }
        if (root.right != null) {
            return 1 + minDepth1(root.right);
        }
        return 1;
    }

    @Test
    public void testMinDepth1() {
        TreeNode root = TreeNodeGenUtils.genByLevelArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(2, minDepth1(root));
    }

    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth + 1;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                count--;
            }
            depth++;
        }

        return depth;
    }
    @Test
    public void testMinDepth2() {
        TreeNode root = TreeNodeGenUtils.genByLevelArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(2, minDepth2(root));
    }

}
