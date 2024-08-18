package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.structure.c11_binarytree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">104. 二叉树的最大深度</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 20:15
 * @Version 1.0
 */
public class E05Leetcode104 {
    public static int maxDepth1(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        return 1 + Math.max(dfs(root.left, depth), dfs(root.right, depth));
    }

    @Test
    public void testMaxDepth1() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        assertEquals(3, maxDepth1(root));
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    @Test
    public void testMaxDepth2() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        assertEquals(3, maxDepth2(root));
    }

    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int count;
        while (!queue.isEmpty()) {
            count = queue.size();
            while (count > 0) {
                TreeNode polled = queue.poll();
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
                count--;
            }
            level++;
        }

        return level;
    }

    @Test
    public void testMaxDepth3() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        assertEquals(3, maxDepth3(root));
    }

    public static int maxDepth4(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode poll = null;
        TreeNode curr = root;
        stack.push(root);
        int depth = 0;
        int maxDepth = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
                depth++;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == poll) {
                    poll = stack.poll();
                    if (depth > maxDepth) {
                        maxDepth = depth;
                    }
                    depth--;
                } else {
                    curr = peek.right;
                }
            }
        }

        return maxDepth;
    }

    @Test
    public void testMaxDepth4() {
        /*
                3
               / \
              9   20
                 /  \
                15   7
         */
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        assertEquals(3, maxDepth4(root));
    }

    public static int maxDepth5(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode poll = null;
        TreeNode curr = root;
        int maxDepth = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == poll) {
                    poll = stack.poll();
                } else {
                    curr = peek.right;
                }
            }
        }

        return maxDepth;
    }

    @Test
    public void testMaxDepth5() {
        /*
                3
               / \
              9   20
                 /  \
                15   7
         */
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        assertEquals(3, maxDepth5(root));
    }
}
