package com.foxtian.structure.c12_bst;

import java.util.*;

/**
 * Description: 二叉搜索树
 *
 * @Author 狐狸半面添
 * @Create 2024/8/19 20:11
 * @Version 1.0
 */
public class BSTTree1 {
    /**
     * 根节点
     */
    private BSTNode root;

    public BSTTree1(BSTNode root) {
        this.root = root;
    }

    public BSTTree1() {
    }

    /**
     * 查找关键字对应的值
     *
     * @param key
     * @return
     */
    public Object get(int key) {
        BSTNode curr = root;
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            } else if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return null;
    }

    /**
     * 递归查找关键字对应的值
     *
     * @param node
     * @param key
     * @return
     */
    public Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return doGet(node.left, key);
        } else if (node.key < key) {
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
    public Object min() {
        if (root == null) {
            return null;
        }

        BSTNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.value;
    }

    /**
     * 递归获取最小关键字关联的值
     *
     * @param node
     * @return
     */
    public Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return doMin(node.left);
        } else {
            return node.value;
        }
    }

    /**
     * 获取最大关键字关联的值
     *
     * @return
     */
    public Object max() {
        if (root == null) {
            return null;
        }
        BSTNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.value;
    }

    /**
     * 递归获取最大关键字关联的值
     *
     * @return
     */
    public Object doMax(BSTNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return doMax(node.right);
        } else {
            return node.value;
        }
    }

    /**
     * 存储关键字和对应值
     *
     * @param key
     * @param value
     */
    public void put(int key, Object value) {
        if (root == null) {
            root = new BSTNode(key, value);
            return;
        }

        BSTNode p = root;
        // 用于记录 p 的父节点，处理 key 不存在的情况
        BSTNode prev = null;
        while (p != null) {
            prev = p;
            if (p.key == key) {
                // key 已经存在了，则只需要更新 value
                p.value = value;
                return;
            } else if (key < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        // 走到这里说明没有找到 key
        // 则需要新增节点
        if (key < prev.key) {
            prev.left = new BSTNode(key, value);
        } else {
            prev.right = new BSTNode(key, value);
        }
    }


    /**
     * 查找关键字的前驱值
     * 当关键字节点存在左子树时，最大值就是左子树的最大值
     * 当关键字节点不存在左子树时，找离它最近的自左而来的祖先，该祖先为前驱，否则没有前驱节点
     * 4
     * /  \
     * 2    7
     * / \  / \
     * 1  3 6  8
     * /
     * 5
     *
     * @param key
     * @return
     */
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode parentFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                // 向右找，则当前 p 是自左而来
                // 记录最近一次自左而来的祖先
                parentFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }

        // 当前节点没有找到
        if (p == null) {
            return null;
        }

        // 找到了节点
        // 1.当关键字节点存在左子树时，最大值就是左子树的最大值
        // 2.当关键字节点不存在左子树时，找离它最近的自左而来的祖先，该祖先为前驱，否则没有前驱节点
        if (p.left != null) {
            return max(p.left);
        } else {
            return parentFromLeft != null ? parentFromLeft.value : null;
        }
    }

    private Object max(BSTNode node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    /**
     * 查找关键字的后继值
     * 1.如果关键字节点有右子树，则右子树的最小节点是后继节点
     * 2.如果关键字节点没有右子树，那么离它最近的自右而来的祖先是后继节点
     *
     * @param key
     * @return
     */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode parentFromRight = null;
        while (p != null) {
            if (key < p.key) {
                parentFromRight = p;
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                break;
            }
        }

        if (p == null) {
            return null;
        }

        // 1.如果关键字节点有右子树，则右子树的最小节点是后继节点
        // 2.如果关键字节点没有右子树，那么离它最近的自右而来的祖先是后继节点
        if (p.right != null) {
            return min(p.right);
        } else {
            return parentFromRight != null ? parentFromRight.value : null;
        }
    }

    private Object min(BSTNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node.value;
    }

    public static boolean isSameKeyTree(BSTTree1 tree1, BSTTree1 tree2) {
        return doIsSameKeyTree(tree1.root, tree2.root);
    }

    public static boolean doIsSameKeyTree(BSTNode node1, BSTNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.key == node2.key) {
            return doIsSameKeyTree(node1.left, node2.left) && doIsSameKeyTree(node1.right, node2.right);
        } else {
            return false;
        }
    }

    /**
     * 根据关键字删除节点
     * 1.删除节点没有左孩子，则将右孩子托孤给 Parent
     * 2.删除节点没有右孩子，则将左孩子托孤给 Parent
     * 3.删除节点左右孩子都没有，已经被覆盖在情况1、2中，把 null 托孤给 Parent
     * 4.删除节点左右孩子都有，可以将它的后继节点 s 托孤给 Parent
     *
     * @param key
     * @return
     */
    public Object delete(int key) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }

        if (p == null) {
            return null;
        }

        if (p.left == null && p.right != null) {
            shift(parent, p, p.right);
        } else if (p.left != null && p.right == null) {
            shift(parent, p, p.left);
        } else if (p.left == null) {
            shift(parent, p, p.left);
        } else {
            // 4.1 被删除节点找后继
            BSTNode s = p.right;
            BSTNode sParent = p; // 后继节点的父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点为 s

            if (sParent != p) {
                // 4.2 删除和后继不相邻，处理后继后事
                shift(sParent, s, s.right);
                s.right = p.right;
            }
            // 4.3 后继节点取代被删除节点
            shift(parent, p, s);
            s.left = p.left;
        }

        return p.value;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        // 此情况下被删除节点是根节点 root
        if (parent == null) {
            root = child;
            return;
        }

        if (parent.left == deleted) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    /**
     * 递归删除
     *
     * @return
     */
    public Object delete2(int key) {
        // 用于保存被删除节点的值
        List<Object> result = new ArrayList<>();
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }

    // 返回值是删剩下的孩子 或 null
    public BSTNode doDelete(BSTNode node, int key, List<Object> result) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = doDelete(node.left, key, result);
            return node;
        } else if (key > node.key) {
            node.right = doDelete(node.right, key, result);
            return node;
        } else {
            // 找到了
            result.add(node.value);

            if (node.left != null && node.right == null) {
                // 情况1：只有左孩子，没有右孩子
                return node.left;
            } else if (node.left == null && node.right != null) {
                // 情况2：只有右孩子，没有左孩子
                return node.right;
            } else if (node.left == null) {
                // 情况3：没有左右孩子
                return null;
            } else {
                BSTNode s = node.right;
                while (s.left != null) {
                    s = s.left;
                }
                // s 是后继节点
                // 以下两行代码的顺序不能调换，因为不能先破坏 s 左子树结构
                s.right = doDelete(node.right, s.key, result);
                s.left = node.left;
                return s;
            }
        }
    }

    /**
     * 返回 < key 的所有 key
     *
     * @param key
     * @return
     */
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key < key) {
                    result.add(pop.key);
                } else {
                    break;
                }
                p = pop.right;
            }
        }

        return result;
    }

    /**
     * 返回 > key 的所有 key
     *
     * @param key
     * @return
     */
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        LinkedList<BSTNode> stack = new LinkedList<>();
        BSTNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key > key) {
                    result.add(pop.key);
                } else {
                    break;
                }
                p = pop.left;
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 返回在区间范围 [key1, key2] 的所有 key
     *
     * @param key1
     * @param key2
     * @return
     */
    public List<Object> between(int key1, int key2) {
        if (key1 > key2) {
            return new ArrayList<>();
        }
        ArrayList<Object> result = new ArrayList<>();
        LinkedList<BSTNode> stack = new LinkedList<>();
        BSTNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.key);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
