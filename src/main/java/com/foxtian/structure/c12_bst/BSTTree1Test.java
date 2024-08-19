package com.foxtian.structure.c12_bst;

import com.foxtian.structure.c12_bst.BSTTree1.BSTNode;
import com.foxtian.utils.ListGenUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/19 20:22
 * @Version 1.0
 */
public class BSTTree1Test {
    private BSTTree1 tree;

    @BeforeEach
    public void init() {
        /*
                4
               / \
              2   6
             / \ / \
            1  3 5  7
         */
        BSTNode n1 = new BSTNode(1, "小1");
        BSTNode n3 = new BSTNode(3, "小3");
        BSTNode n2 = new BSTNode(2, "小2", n1, n3);

        BSTNode n5 = new BSTNode(5, "小5");
        BSTNode n7 = new BSTNode(7, "小7");
        BSTNode n6 = new BSTNode(6, "小6", n5, n7);

        BSTNode n4 = new BSTNode(4, "小4", n2, n6);

        tree = new BSTTree1(n4);
    }

    /**
     * 测试 {@link BSTTree1#get(int)}
     */
    @Test
    public void testGet() {
        assertEquals("小1", tree.get(1));
        assertEquals("小2", tree.get(2));
        assertEquals("小3", tree.get(3));
        assertEquals("小4", tree.get(4));
        assertEquals("小5", tree.get(5));
        assertEquals("小6", tree.get(6));
        assertEquals("小7", tree.get(7));
        assertNull(tree.get(8));
    }

    /**
     * 测试 {@link BSTTree1#min()}
     */
    @Test
    public void testMin() {
        assertEquals("小1", tree.min());
    }

    /**
     * 测试 {@link BSTTree1#max()}
     */
    @Test
    public void testMax() {
        assertEquals("小7", tree.max());
    }

    /**
     * 测试 {@link BSTTree1#put(int, Object)}
     */
    @Test
    public void testPut() {
        BSTTree1 tree2 = new BSTTree1();
        tree2.put(4, "小4");
        tree2.put(2, "小2");
        tree2.put(6, "小6");
        tree2.put(1, "小1");
        tree2.put(3, "小3");
        tree2.put(7, "小7");
        tree2.put(5, "小5");

        assertTrue(BSTTree1.isSameKeyTree(tree, tree2));
    }

    /**
     * 测试 {@link BSTTree1#predecessor(int)}
     */
    @Test
    public void testPredecessor() {
        assertNull(tree.predecessor(1));
        assertEquals("小1", tree.predecessor(2));
        assertEquals("小2", tree.predecessor(3));
        assertEquals("小3", tree.predecessor(4));
        assertEquals("小4", tree.predecessor(5));
        assertEquals("小5", tree.predecessor(6));
        assertEquals("小6", tree.predecessor(7));
    }

    /**
     * 测试 {@link BSTTree1#successor(int)}
     */
    @Test
    public void testSuccessor() {
        assertEquals("小2", tree.successor(1));
        assertEquals("小3", tree.successor(2));
        assertEquals("小4", tree.successor(3));
        assertEquals("小5", tree.successor(4));
        assertEquals("小6", tree.successor(5));
        assertEquals("小7", tree.successor(6));
        assertNull(tree.successor(7));
    }

    /**
     * 测试 {@link BSTTree1#less(int)}
     */
    @Test
    public void testLess() {
        assertIterableEquals(ListGenUtils.toList(), tree.less(1));
        assertIterableEquals(ListGenUtils.toList(1), tree.less(2));
        assertIterableEquals(ListGenUtils.toList(1,2), tree.less(3));
        assertIterableEquals(ListGenUtils.toList(1,2,3), tree.less(4));
        assertIterableEquals(ListGenUtils.toList(1,2,3,4), tree.less(5));
        assertIterableEquals(ListGenUtils.toList(1,2,3,4,5), tree.less(6));
        assertIterableEquals(ListGenUtils.toList(1,2,3,4,5,6), tree.less(7));
        assertIterableEquals(ListGenUtils.toList(1,2,3,4,5,6,7), tree.less(8));
    }

    /**
     * 测试 {@link BSTTree1#greater(int)}
     */
    @Test
    public void testGreater() {
        assertIterableEquals(ListGenUtils.toList(), tree.greater(7));
        assertIterableEquals(ListGenUtils.toList(7), tree.greater(6));
        assertIterableEquals(ListGenUtils.toList(6,7), tree.greater(5));
        assertIterableEquals(ListGenUtils.toList(5,6,7), tree.greater(4));
        assertIterableEquals(ListGenUtils.toList(4,5,6,7), tree.greater(3));
        assertIterableEquals(ListGenUtils.toList(3,4,5,6,7), tree.greater(2));
        assertIterableEquals(ListGenUtils.toList(2,3,4,5,6,7), tree.greater(1));
        assertIterableEquals(ListGenUtils.toList(1,2,3,4,5,6,7), tree.greater(0));
    }

    /**
     * 测试 {@link BSTTree1#between(int, int)}
     */
    @Test
    public void testBetween() {
        assertIterableEquals(ListGenUtils.toList(), tree.between(1, 0));
        assertIterableEquals(ListGenUtils.toList(), tree.between(8, 9));
        assertIterableEquals(ListGenUtils.toList(1,2,3), tree.between(1,3));
        assertIterableEquals(ListGenUtils.toList(5,6,7), tree.between(5,8));
        assertIterableEquals(ListGenUtils.toList(5,6,7), tree.between(5,7));
        assertIterableEquals(ListGenUtils.toList(4,5,6,7), tree.between(4,8));
        assertIterableEquals(ListGenUtils.toList(3,4,5,6,7), tree.between(3,10));
        assertIterableEquals(ListGenUtils.toList(2,3,4,5,6,7), tree.between(2,7));
        assertIterableEquals(ListGenUtils.toList(1,2,3,4,5,6,7), tree.between(-1,7));
    }
}
