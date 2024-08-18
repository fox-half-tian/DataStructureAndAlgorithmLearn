package com.foxtian.structure.c11_binarytree.exec;

import com.foxtian.structure.c11_binarytree.TreeNode;
import org.junit.jupiter.api.BeforeAll;

/**
 * Description:
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
         */
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, node5, node6);

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node4, null);

        TreeNode node1 = new TreeNode(1, node2, node3);

        root = node1;
    }


}
