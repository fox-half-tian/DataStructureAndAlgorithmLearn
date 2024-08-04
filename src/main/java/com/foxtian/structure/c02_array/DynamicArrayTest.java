package com.foxtian.structure.c02_array;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/3 16:26
 * @Version 1.0
 */
public class DynamicArrayTest {

    /**
     * 测试向最后位置添加元素 {@link DynamicArray#addLast(int)}
     */
    @Test
    public void testAddLast() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        assert 1 == dynamicArray.get(0);
        assert 2 == dynamicArray.get(1);
        assert 3 == dynamicArray.get(2);
        assert 4 == dynamicArray.get(3);
        assert 5 == dynamicArray.get(4);
    }

    /**
     * 测试插入元素 {@link DynamicArray#add(int, int)}
     */
    @Test
    public void testAdd() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.add(2, 6);

        assert 1 == dynamicArray.get(0);
        assert 2 == dynamicArray.get(1);
        assert 6 == dynamicArray.get(2);
        assert 3 == dynamicArray.get(3);
        assert 4 == dynamicArray.get(4);
        assert 5 == dynamicArray.get(5);
    }

    /**
     * 测试遍历元素 {@link DynamicArray#foreach()}
     */
    @Test
    public void testForeachBasic() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.foreach();
    }

    /**
     * 测试接收一个泛型参数的消费者 {@link DynamicArray#foreach(Consumer)}
     */
    @Test
    public void testForeachConsumer() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.foreach(System.out::println);
    }

    /**
     * 测试接收两个泛型参数的消费者 {@link DynamicArray#foreach(BiConsumer)}
     */
    @Test
    public void testForeachBiConsumer() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.foreach((v, i) -> System.out.printf("array[%d] = %d\n", i, v));
    }

    /**
     * 测试迭代器遍历 {@link DynamicArray#iterator()}
     */
    @Test
    public void testIterator() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        for (Integer value : dynamicArray) {
            System.out.println(value);
        }

        // 等价于
        Iterator<Integer> iterator = dynamicArray.iterator();
        while (iterator.hasNext()) {
            Integer nextValue = iterator.next();
            System.out.println(nextValue);
        }
    }

    /**
     * 测试迭代器遍历 {@link DynamicArray#stream()}
     */
    @Test
    public void testStream() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.stream().forEach(System.out::println);
    }

    /**
     * 测试删除元素 {@link DynamicArray#remove(int)}
     */
    @Test
    public void testRemove() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(2);
        assert 3 == removed;

        assert 1 == dynamicArray.get(0);
        assert 2 == dynamicArray.get(1);
        assert 4 == dynamicArray.get(2);
        assert 5 == dynamicArray.get(3);
    }
}
