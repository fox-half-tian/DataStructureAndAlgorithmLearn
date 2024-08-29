package com.foxtian.doclearn;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.condition.OS;

import java.util.*;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/17 22:20
 * @Version 1.0
 */
public class TreeTraversal2 {
    public static void main(String[] args) {
        Node H = new Node("H", null, null);
        Node D = new Node("D", null, H);
        Node I = new Node("I", null, null);
        Node E = new Node("E", null, I);
        Node B = new Node("B", D, E);

        Node J = new Node("J", null, null);
        Node K = new Node("K", null, null);
        Node F = new Node("F", J, K);
        Node G = new Node("G", null, null);
        Node C = new Node("C", F, G);

        Node A = new Node("A", B, C);

        levelTraverse(A);
    }

    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void levelTraverse(Node node) {
        if (node == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> levelRes = new ArrayList<>();
            while (size > 0) {
                Node poll = queue.poll();
                levelRes.add(poll.val);

                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }

                size--;
            }
            System.out.println(levelRes);
        }
    }


    /**
     * 递归实现前序遍历
     */
    public static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + "\t");
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 非递归实现中序遍历
     *
     * @param node
     */
    public static void inorder(Node node) {
        if (node == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        Node curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // 此时的 curr 一定是某个节点 parent 的左节点，只不过该左节点为 null
                // 而 parent 一定在当前栈的栈顶
                Node parent = stack.pop();
                // 由于已经遍历完左子树，因此在中序遍历中当前位置就可以打印 parent
                System.out.print(parent.val + "\t");
                // 再遍历右子树
                curr = parent.right;
            }
        }
    }

    /**
     * 递归实现后序遍历
     *
     * @param node
     */
    public static void postorder(Node node) {
        if (node == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        Node curr = node;
        // 记录上一次出栈的节点
        Node pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // 此时的 curr 一定是某个节点 parent 的左节点，只不过该左节点为 null
                // 而 parent 一定在当前栈的栈顶
                // 与前中序遍历不同，我们不能立即将 parent 出栈，因为需要先遍历了 parent 右子树
                // 那如何标记当前是否已经遍历了 parent 右子树呢？
                Node parent = stack.peek();

                // 事实上，我们的 pop 记录的是上一次出栈的节点
                // 那么如果已经遍历了右子树，则当前 parent.right 就是上一次出栈的节点 pop
                if (parent.right == null || parent.right == pop) {
                    System.out.print(parent.val + "\t");
                    // 记录为上一次出栈节点，给 pop 的父节点判断是否已经遍历了右子树
                    pop = stack.pop();
                } else {
                    // 如果 parent.right != pop，则还未遍历 parent 的右子树
                    curr = parent.right;
                }
            }
        }
    }

    public static void order(Node node) {
        if (node == null) {
            return;
        }

        // 记录前序遍历结果
        ArrayList<String> preorderList = new ArrayList<>();
        // 记录中序遍历结果
        ArrayList<String> inorderList = new ArrayList<>();
        // 记录后序遍历结果
        ArrayList<String> postorderList = new ArrayList<>();

        LinkedList<Node> stack = new LinkedList<>();
        Node curr = node;
        // 记录上一次出栈的节点
        Node pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                preorderList.add(curr.val);
                curr = curr.left;
            } else {
                // 此时的 curr 一定是某个节点 parent 的左节点，只不过该左节点为 null
                // 而 parent 一定在当前栈的栈顶
                Node parent = stack.peek();

                // 1.无右子树，则中序和后序可采取相同措施
                if (parent.right == null) {
                    inorderList.add(parent.val);
                    postorderList.add(parent.val);

                    pop = stack.pop();
                } else if (parent.right == pop) {
                    // 2.有右子树，且已经遍历完了右子树，则后序遍历需要打印节点值
                    postorderList.add(parent.val);
                    pop = stack.pop();
                } else {
                    // 3.有右子树，且还没有开始遍历右子树，则中序遍历需要打印节点值
                    inorderList.add(parent.val);
                    // 然后继续遍历右子树
                    curr = parent.right;
                }
            }
        }

        System.out.println("前序遍历结果：" + preorderList);
        System.out.println("中序遍历结果：" + inorderList);
        System.out.println("后序遍历结果：" + postorderList);
    }
}
