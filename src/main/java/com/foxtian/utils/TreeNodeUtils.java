package com.foxtian.utils;

import com.foxtian.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 20:48
 * @Version 1.0
 */
public class TreeNodeUtils {
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = nodes.length - 1; i >= 0; i--) {
            if (array[i] == null) {
                continue;
            }

            int left = (i << 1) + 1;
            int right = left + 1;
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            if (left < nodes.length) {
                leftNode = nodes[left];
            }
            if (right < nodes.length) {
                rightNode = nodes[right];
            }
            nodes[i] = new TreeNode(array[i], leftNode, rightNode);
        }

        return nodes[0];
    }

    public static Integer[] treeNodeToArray(TreeNode node) {
        if (node == null) {
            return new Integer[]{null};
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        boolean allNull = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            if (allNull) {
                break;
            }
            allNull = true;
            while (count > 0) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    list.add(null);
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    list.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                    if (poll.left != null || poll.right != null) {
                        allNull = false;
                    }
                }
                count--;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                list.remove(i);
            } else {
                break;
            }
        }
        Integer[] res = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
