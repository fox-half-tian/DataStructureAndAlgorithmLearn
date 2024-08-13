package com.foxtian.doclearn;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/12 18:38
 * @Version 1.0
 */
public class Person {
    public static Person person = new Person();

    static {
        System.out.println("静态代码块执行");
    }

    Person() {
        System.out.println("构造器执行");
    }

    public static void main(String[] args) {
        int[] person = new int[10];
        person[1] = 10;
    }

    class B {

    }
}

class B {
    public static void main(String[] args) {
        System.out.println(f(2)); // 3
    }

    public static int f(int value) {
        try {
            return ++value;
        } finally {
            value += 100;
        }
    }
}