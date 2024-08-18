package com.foxtian.utils;

import com.foxtian.entity.TreeNode;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/18 20:48
 * @Version 1.0
 */
public class TreeNodeGenUtils {
    public static TreeNode genByLevelArray(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = nodes.length - 1; i >= 0; i--) {
            if (nodes[i] == null) {
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
}
