package com.foxtian.doclearn;

import java.lang.reflect.Field;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 17:01
 * @Version 1.0
 */
public class RealTypeTest {
    public static void main(String[] args) throws NoSuchFieldException {
        A<String> a = new A<>();

        Field objField = A.class.getDeclaredField("obj");
        System.out.println(objField.getType().getName());
    }

    static class A<E> {
        E obj;
    }
}
