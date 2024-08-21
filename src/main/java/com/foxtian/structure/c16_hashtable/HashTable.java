package com.foxtian.structure.c16_hashtable;

import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: 哈希表
 *
 * @Author 狐狸半面添
 * @Create 2024/8/21 0:34
 * @Version 1.0
 */
public class HashTable {
    /**
     * 节点类
     */
    static class Entry {
        /**
         * 哈希码
         */
        int hash;

        /**
         * 键
         */
        Object key;

        /**
         * 值
         */
        Object value;

        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    Entry[] table = new Entry[16];

    /**
     * 元素个数
     */
    int size = 0;

    /**
     * 负载因子
     * 阈值 = 负载因子 * 数组长度
     */
    float loadFactor = 0.75f;
    int threshold = (int) (table.length * loadFactor);

    /**
     * 根据 hash 码获取 value
     *
     * @param hash
     * @param key
     * @return
     */
     Object get(int hash, Object key) {
        int idx = hash & (table.length - 1);
        Entry p = table[idx];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public Object get(Object key) {
        int hash = getHash(key);
        return get(hash, key);
    }

    /**
     * 向 hash 表存入新 key value，如果 key 重复，则更新 value
     *
     * @param hash
     * @param key
     * @param value
     */
     void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            table[idx] = new Entry(hash, key, value);
            size++;
            return;
        }
        Entry p = table[idx];
        do {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        } while (p.next != null && (p = p.next) != null);
        p.next = new Entry(hash, key, value);
        size++;

        if (size > threshold) {
            resize();
        }
    }

    public void put(Object key, Object value) {
        int hash = getHash(key);
        put(hash,key,value);
    }

    private int getHash(Object key) {
        return key.hashCode();
    }

    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            Entry a = null;
            Entry b = null;
            Entry aHead = null;
            Entry bHead = null;
            while (p != null) {
                if ((p.hash & table.length) == 0) {
                    // 分配到 a
                    if (a != null) {
                        a.next = p;
                    } else {
                        aHead = p;
                    }
                    a = p;
                } else {
                    // 分配到 b
                    if (b != null) {
                        b.next = p;
                    } else {
                        bHead = p;
                    }
                    b = p;
                }
                p = p.next;
            }
            if (a != null) {
                a.next = null;
                newTable[i] = aHead;
            }
            if (b != null) {
                b.next = null;
                newTable[i + table.length] = bHead;
            }
        }

        table = newTable;
        threshold = (int) (table.length * loadFactor);
    }

    /**
     * 根据 hash 码删除，返回删除的 value
     *
     * @param hash
     * @param key
     * @return
     */
    Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }

        Entry p = table[idx];
        if (p.key.equals(key)) {
            size--;
            table[idx] = p.next;
            return p.value;
        }

        while (p.next != null) {
            if (p.next.key.equals(key)) {
                Entry removed = p.next;
                p.next = p.next.next;
                size--;
                return removed.value;
            }
        }

        return null;
    }

    public void print() {
        int[] sums = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            while (p != null) {
                sums[i]++;
                p = p.next;
            }
        }
        // System.out.println(Arrays.toString(sums));

        Map<Integer, Long> map = Arrays.stream(sums).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map);
    }
}
