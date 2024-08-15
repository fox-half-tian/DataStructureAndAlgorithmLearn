package com.foxtian.structure.c07_deque.exec;

import com.foxtian.utils.ListShowUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">103. 二叉树的锯齿形层序遍历</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 21:15
 * @Version 1.0
 */
public class E01Leetcode103 {
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offerLast(root);
        boolean isLeftToRight = true;
        int count = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> levelRes = new ArrayList<>(count);
            if (isLeftToRight) {
                while (count > 0) {
                    TreeNode pollNode = deque.pollFirst();
                    levelRes.add(pollNode.val);
                    if (pollNode.left != null) {
                        deque.offerLast(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        deque.offerLast(pollNode.right);
                    }
                    count--;
                }
                isLeftToRight = false;
            } else {
                while (count > 0) {
                    TreeNode pollNode = deque.pollLast();
                    levelRes.add(pollNode.val);
                    if (pollNode.right != null) {
                        deque.offerFirst(pollNode.right);
                    }
                    if (pollNode.left != null) {
                        deque.offerFirst(pollNode.left);
                    }
                    count--;
                }
                isLeftToRight = true;
            }
            res.add(levelRes);
            count = deque.size();
        }

        return res;
    }

    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offerLast(root);
        boolean isLeftToRight = true;
        int count = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> levelRes = new LinkedList<>();
            if (isLeftToRight) {
                while (count > 0) {
                    TreeNode pollNode = queue.poll();
                    levelRes.offerLast(pollNode.val);
                    if (pollNode.left != null) {
                        queue.offer(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        queue.offer(pollNode.right);
                    }
                    count--;
                }
            } else {
                while (count > 0) {
                    TreeNode pollNode = queue.poll();
                    levelRes.offerFirst(pollNode.val);
                    if (pollNode.left != null) {
                        queue.offer(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        queue.offer(pollNode.right);
                    }
                    count--;
                }
            }
            isLeftToRight = !isLeftToRight;
            res.add(levelRes);
            count = queue.size();
        }

        return res;
    }

    @Test
    public void testZigzagLevelOrder1() {
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);
        List<List<Integer>> res = zigzagLevelOrder1(node3);
        for (List<Integer> levelRes : res) {
            System.out.println(ListShowUtils.getListItemsStr(levelRes));
        }
    }

    @Test
    public void testZigzagLevelOrder2() {
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);
        List<List<Integer>> res = zigzagLevelOrder2(node3);
        for (List<Integer> levelRes : res) {
            System.out.println(ListShowUtils.getListItemsStr(levelRes));
        }
    }
}
