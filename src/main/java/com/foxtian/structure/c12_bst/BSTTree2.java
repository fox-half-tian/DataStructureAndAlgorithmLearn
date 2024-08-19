package com.foxtian.structure.c12_bst;

/**
 * Description: 二叉搜索树，泛型 key 版本
 *
 * @Author 狐狸半面添
 * @Create 2024/8/19 20:11
 * @Version 1.0
 */
public class BSTTree2<T extends Comparable<T>, V> {
    /**
     * 根节点
     */
    private final BSTNode<T, V> root;

    public BSTTree2(BSTNode<T, V> root) {
        this.root = root;
    }

    /**
     * 查找关键字对应的值
     *
     * @param key
     * @return
     */
    public V get(T key) {
        BSTNode<T, V> curr = root;
        while (curr != null) {
            /*
                -1 key < curr.key
                0 key == curr.key
                1 key > curr.key
             */
            int res = key.compareTo(curr.key);
            if (res == 0) {
                return curr.value;
            } else if (res < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return null;
    }

    /**
     * 递归查找关键字对应的值
     * @param node
     * @param key
     * @return
     */
    public V doGet(BSTNode<T, V> node, T key) {
        if (node == null) {
            return null;
        }

        int res = key.compareTo(node.key);
        if (res < 0) {
            return doGet(node.left, key);
        } else if (res > 0) {
            return doGet(node.right, key);
        } else {
            return node.value;
        }
    }

    /**
     * 获取最小关键字关联的值
     *
     * @return
     */
    public V min() {
        return null;
    }

    /**
     * 获取最大关键字关联的值
     *
     * @return
     */
    public V max() {
        return null;
    }

    /**
     * 存储关键字和对应值
     *
     * @param key
     * @param value
     */
    public void put(T key, V value) {

    }

    /**
     * 查找关键字的后继值
     *
     * @param key
     * @return
     */
    public V successor(T key) {
        return null;
    }

    /**
     * 查找关键字的前驱值
     *
     * @param key
     * @return
     */
    public V predecessor(T key) {
        return null;
    }

    /**
     * 根据关键字删除节点
     *
     * @param key
     * @return
     */
    public V delete(T key) {
        return null;
    }

    static class BSTNode<T extends Comparable<T>, V> {
        T key;
        V value;
        BSTNode<T, V> left;
        BSTNode<T, V> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, V value, BSTNode<T, V> left, BSTNode<T, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
