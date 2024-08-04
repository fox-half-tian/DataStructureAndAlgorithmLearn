package com.foxtian.structure.c02_array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Description: 动态数组
 *
 * @Author 狐狸半面添
 * @Create 2024/8/3 16:11
 * @Version 1.0
 */
public class DynamicArray implements Iterable<Integer> {
    /**
     * 逻辑大小
     */
    private int size = 0;

    /**
     * 容量
     */
    private int capacity = 8;

    // 懒惰初始化
    private int[] array = {};

    /**
     * 向最后位置 [size] 添加元素
     * <p>测试案例查看 {@link DynamicArrayTest#testAddLast()}</p>
     *
     * @param element 待添加元素
     */
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 向 [0...size] 位置添加元素
     * <p>测试案例查看 {@link DynamicArrayTest#testAdd()}</p>
     *
     * @param index   索引位置
     * @param element 待添加元素
     */
    public void add(int index, int element) {
        if (!(index >= 0 && index <= size)) {
            return;
        }

        // 容量检查
        checkAndGrow();

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 容量检查，如果达到临界需要扩容
     */
    public void checkAndGrow() {
        if (array.length == 0) {
            array = new int[capacity];
        }

        if (size != capacity) {
            return;
        }
        capacity += capacity >> 1;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    /**
     * 删除在 [0, size) 范围内的元素
     * <p>测试案例查看 {@link DynamicArrayTest#testRemove()}</p>
     *
     * @param index 删除该索引位置的元素
     * @return 删除索引位置的元素值
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int removed = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        return removed;
    }

    /**
     * 查找元素
     *
     * @param index 索引位置，在 [0, size) 区间内
     * @return 该索引位置的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }


    /**
     * 遍历数组
     * <p>测试案例查看 {@link DynamicArrayTest#testForeachBasic()}</p>
     */
    public void foreach() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 遍历数组，要做的事情通过函数式接口的方式传进来
     * <p>函数式接口需要一个参数</p>
     * <p>测试案例查看 {@link DynamicArrayTest#testForeachConsumer()}</p>
     *
     * @param consumer 接收一个泛型参数的消费者，这个泛型参数的值是数组元素值
     * @see Consumer#accept(Object)
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历数组，要做的事情通过函数式接口的方式传进来
     * <p>函数式接口需要两个参数</p>
     * <p>测试案例查看 {@link DynamicArrayTest#testForeachBiConsumer()}</p>
     *
     * @param consumer 接收两个个泛型参数的消费者，一是数组元素值，二是索引
     * @see BiConsumer#accept(Object, Object)
     */
    public void foreach(BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i], i);
        }
    }

    /**
     * 迭代器遍历
     * <p>测试案例查看 {@link DynamicArrayTest#testIterator()}</p>
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int curIndex = 0;

            /**
             * 是否还存在下一个元素
             * @return
             */
            @Override
            public boolean hasNext() {
                return curIndex != size;
            }

            /**
             * 返回当前元素，并将指针指向下一个元素
             * @return
             */
            @Override
            public Integer next() {
                return array[curIndex++];
            }
        };
    }

    /**
     * 流遍历
     * <p>测试案例查看 {@link DynamicArrayTest#testStream()}</p>
     *
     * @return
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
