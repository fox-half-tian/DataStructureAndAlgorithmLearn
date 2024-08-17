package com.foxtian.structure.c11_binarytree;

import java.util.LinkedList;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 22:20
 * @Version 1.0
 */
public class TreeTraversal {
    public static void main(String[] args) {
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

        TreeNode root = node1;

        System.out.println("递归：");
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

        System.out.println("\n非递归：");
        preOrderByStack(root);
        System.out.println();
        inOrderByStack(root);
        System.out.println();
        postOrderByStack1(root);
        System.out.println();
        postOrderByStack2(root);

        System.out.println("\n非递归统一模版：");
        preOrderByTemplate(root);
        System.out.println();
        inOrderByTemplate(root);
        System.out.println();
        postOrderByTemplate(root);

    }

    /**
     * 前序遍历
     *
     * @param node
     */
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    static void preOrderByStack(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.val + "\t");
                // 记住回来的路
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
    }


    /**
     * 中序遍历
     *
     * @param node
     */
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    static void inOrderByStack(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val + "\t");
                curr = pop.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "\t");
    }

    /**
     * 后序遍历1
     * @param node
     */
    static void postOrderByStack1(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.peek() != null) {
                    curr = stack.peek().right;
                    // 将 null 作为右子树已经处理完成的标识
                    stack.push(null);
                } else {
                    stack.pop();
                    TreeNode pop = stack.pop();
                    System.out.print(pop.val + "\t");
                }
            }
        }
    }

    /**
     * 后序遍历2
     * @param node
     */
    static void postOrderByStack2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        // 记录最近一次弹栈元素
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    System.out.print(pop.val + "\t");
                } else {
                    curr = peek.right;
                }
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    static void preOrderByTemplate(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        // 记录最近一次弹栈元素
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                System.out.print(curr.val + "\t");
                // 处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树（右子树处理完成）
                if (peek.right == null){
                    pop = stack.pop();
                }else if( peek.right == pop) { // 处理完右子树
                    pop = stack.pop();
                } else { // 待处理右子树
                    curr = peek.right;
                }
            }
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    static void inOrderByTemplate(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        // 记录最近一次弹栈元素
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                // 处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树（右子树处理完成）
                if (peek.right == null){
                    System.out.print(peek.val + "\t");
                    pop = stack.pop();
                }else if( peek.right == pop) { // 处理完右子树
                    pop = stack.pop();
                } else { // 待处理右子树
                    System.out.print(peek.val + "\t");
                    curr = peek.right;
                }
            }
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    static void postOrderByTemplate(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        // 记录最近一次弹栈元素
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                // 处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树（右子树处理完成）
                if (peek.right == null){
                    pop = stack.pop();
                    System.out.print(pop.val + "\t");
                }else if( peek.right == pop) { // 处理完右子树
                    pop = stack.pop();
                    System.out.print(pop.val + "\t");
                } else { // 待处理右子树
                    curr = peek.right;
                }
            }
        }
    }
}
