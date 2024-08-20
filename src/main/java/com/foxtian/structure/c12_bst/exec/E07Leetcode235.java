package com.foxtian.structure.c12_bst.exec;

import com.foxtian.entity.TreeNode;

/**
 * Description: <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. 二叉搜索树的最近公共祖先</a>
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 0:25
 * @Version 1.0
 */
public class E07Leetcode235 {
    /**
     * 递归版本
     * 待查找节点 p q 在某个结点两侧，则此节点就是最近的公共祖先
     * 否则继续向某一侧节点查找
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else {
            return root;
        }
    }

    // 非递归版本
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }
}
