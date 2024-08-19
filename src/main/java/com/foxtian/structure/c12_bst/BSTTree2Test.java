package com.foxtian.structure.c12_bst;

import com.foxtian.structure.c12_bst.BSTTree2.BSTNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/19 20:22
 * @Version 1.0
 */
public class BSTTree2Test {
    private  static BSTTree2<Integer, String> tree;

    @BeforeAll
    public static void init() {
        /*
                4
               / \
              2   6
             / \ / \
            1  3 5  7
         */
        BSTNode<Integer,String> n1 = new BSTNode<>(1, "小1");
        BSTNode<Integer,String> n3 = new BSTNode<>(3, "小3");
        BSTNode<Integer,String> n2 = new BSTNode<>(2, "小2", n1, n3);

        BSTNode<Integer,String> n5 = new BSTNode<>(5, "小5");
        BSTNode<Integer,String> n7 = new BSTNode<>(7, "小7");
        BSTNode<Integer,String> n6 = new BSTNode<>(6, "小6", n5, n7);

        BSTNode<Integer,String> n4 = new BSTNode<>(4, "小4", n2, n6);

        tree = new BSTTree2<>(n4);
    }

    /**
     * 测试 {@link BSTTree2#get(Comparable)}
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
}
