package com.foxtian.structure.c16_hashtable;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 20:32
 * @Version 1.0
 */
public class HashTableTest {

    /**
     * 测试 {@link HashTable#put(int, Object, Object)}
     */
    @Test
    public void testPut() {
        HashTable table = new HashTable();
        table.put(1, "zhang", "张三");
        table.put(17, "li", "李四");
        table.put(2, "wang", "王五");

        assertEquals(3, table.size);
        assertEquals("张三", table.table[1].value);
        assertEquals("李四", table.table[1].next.value);
        assertEquals("王五", table.table[2].value);

        table.put(1, "zhang", "张4");
        table.put(17, "li", "李5");

        assertEquals("张4", table.table[1].value);
        assertEquals("李5", table.table[1].next.value);
    }

    @Test
    public void testHashCollisions1() {
        HashTable table = new HashTable();
        for (int i = 0; i < 200000; i++) {
            Object obj = new Object();
            table.put(obj, obj);
        }

        table.print();
    }

    @Test
    public void testHashCollisions2() {
        HashTable table = new HashTable();
        for (int i = 0; i < 200000; i++) {
            Object obj = UUID.randomUUID().toString();
            table.put(obj, obj);
        }

        table.print();
    }
}
