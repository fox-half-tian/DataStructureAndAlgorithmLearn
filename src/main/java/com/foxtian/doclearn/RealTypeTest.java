package com.foxtian.doclearn;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/22 17:01
 * @Version 1.0
 */
public class RealTypeTest {
    public static void main(String[] args) throws NoSuchFieldException {
        ReentrantLock lock = new ReentrantLock();
        boolean b = lock.tryLock();
    }
}
