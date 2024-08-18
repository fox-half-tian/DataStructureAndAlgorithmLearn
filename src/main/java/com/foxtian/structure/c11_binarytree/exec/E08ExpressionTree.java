package com.foxtian.structure.c11_binarytree.exec;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Description: 后缀表达式转表达式树
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 22:26
 * @Version 1.0
 */
public class E08ExpressionTree {
    static class TreeNode {
        private String val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    public TreeNode constructExpressionTree(String[] tokens) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)
                    || "-".equals(token)
                    || "*".equals(token)
                    || "/".equals(token)) {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                stack.push(new TreeNode(token, left, right));
            } else {
                stack.push(new TreeNode(token));
            }
        }
        return stack.pop();
    }

    @Test
    public void testConstructExpressionTree() {
        String[] tokens = {"2", "1", "-", "3", "*"};
        ArrayList<String> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = constructExpressionTree(tokens);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            res.add(pop.val);
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
        assertIterableEquals(Arrays.asList("*", "-", "3", "2", "1"), res);
    }
}
