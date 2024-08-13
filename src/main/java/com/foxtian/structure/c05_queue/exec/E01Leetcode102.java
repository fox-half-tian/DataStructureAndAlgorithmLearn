package com.foxtian.structure.c05_queue.exec;

import com.foxtian.utils.ListShowUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">102. 二叉树的层序遍历<a/>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/12 23:10
 * @Version 1.0
 */
public class E01Leetcode102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (count != 0) {
                TreeNode first = queue.poll();
                list.add(first.val);
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
                count--;
            }
            res.add(list);
            count = queue.size();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        List<List<Integer>> res = levelOrder(node3);
        for (List<Integer> list : res) {
            System.out.println(ListShowUtils.getListItemsStr(list));
        }
    }
}
