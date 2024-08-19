package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.structure.c11_binarytree.TreeNode;
import com.foxtian.utils.ListGenUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Description: <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">145. 二叉树的后序遍历</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 22:58
 * @Version 1.0
 */
public class E03Leetcode145 {
    private static TreeNode root;

    @BeforeAll
    public static void init() {
                /*
                   1
                  / \
                 2  3
                /  / \
               4  5   6
         */
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, node5, node6);

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node4, null);

        TreeNode node1 = new TreeNode(1, node2, node3);

        root = node1;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        postorder(node.left, res);
        postorder(node.right, res);

        res.add(node.val);
    }

    @Test
    public void testPostorderTraversal1() {
        List<Integer> res = postorderTraversal1(root);
        assertIterableEquals(ListGenUtils.toList(4, 2, 5, 6, 3, 1), res);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    res.add(stack.pop().val);
                    pop = peek;
                } else {
                    curr = peek.right;
                }
            }
        }

        return res;
    }

    @Test
    public void testPostorderTraversal2() {
        List<Integer> res = postorderTraversal2(root);
        assertIterableEquals(ListGenUtils.toList(4, 2, 5, 6, 3, 1), res);
    }

}
