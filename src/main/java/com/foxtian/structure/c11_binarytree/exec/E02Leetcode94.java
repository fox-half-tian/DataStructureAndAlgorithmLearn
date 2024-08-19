package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.structure.c11_binarytree.TreeNode;
import com.foxtian.utils.ListGenUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">94. 二叉树的中序遍历</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 22:58
 * @Version 1.0
 */
public class E02Leetcode94 {
    private static TreeNode root;

    @BeforeAll
    public static void init() {
        /*
                   1
                  / \
                 2  3
                /  / \
               4  5   6

              4, 2, 1, 5, 3, 6
         */
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, node5, node6);

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node4, null);

        TreeNode node1 = new TreeNode(1, node2, node3);

        root = node1;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    @Test
    public void testInorderTraversal1() {
        List<Integer> res = inorderTraversal1(root);
        assertIterableEquals(ListGenUtils.toList(4, 2, 1, 5, 3, 6), res);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode poll = null;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    poll = stack.poll();
                    res.add(peek.val);
                } else if (peek.right == poll) {
                    poll = stack.poll();
                } else {
                    curr = peek.right;
                    res.add(peek.val);
                }
            }
        }

        return res;
    }

    @Test
    public void testInorderTraversal2() {
        List<Integer> res = inorderTraversal2(root);
        assertIterableEquals(ListGenUtils.toList(4, 2, 1, 5, 3, 6), res);
    }

    public static List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek != null) {
                    if (peek.right != null) {
                        curr = peek.right;
                        res.add(peek.val);
                        stack.push(null);
                    } else {
                        res.add(stack.pop().val);
                    }
                } else {
                    stack.pop();
                    stack.pop();
                }
            }

        }

        return res;
    }

    @Test
    public void testInorderTraversal3() {
        List<Integer> res = inorderTraversal3(root);
        assertIterableEquals(ListGenUtils.toList(4, 2, 1, 5, 3, 6), res);
    }
}
