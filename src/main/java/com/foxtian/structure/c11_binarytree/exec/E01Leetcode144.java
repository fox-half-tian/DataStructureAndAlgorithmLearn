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
 * Description: <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description/">144. 二叉树的前序遍历</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 22:58
 * @Version 1.0
 */
public class E01Leetcode144 {

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

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrder(root, res);
        return res;
    }

    public static void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    @Test
    public void testPreorderTraversal1() {
        assertIterableEquals(ListGenUtils.toList(1, 2, 4, 3, 5, 6), preorderTraversal1(root));
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 记录最近一次弹出栈的节点
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树，等价于右子树遍历完成
                if (peek.right == null) {
                    pop = stack.pop();
                } else if (peek.right == pop) { // 右子树处理完成
                    pop = stack.pop();
                } else {
                    // 还没有处理右子树
                    curr = peek.right;
                }
            }
        }

        return res;
    }

    @Test
    public void testPreorderTraversal2() {
        assertIterableEquals(ListGenUtils.toList(1, 2, 4, 3, 5, 6), preorderTraversal2(root));
    }
}
