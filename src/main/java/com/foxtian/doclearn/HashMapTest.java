package com.foxtian.doclearn;

import java.util.HashMap;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 18:22
 * @Version 1.0
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(new Student(1), 1);
        map.put(new Student(2), 2);
        map.put(new Student(3), 3);
        map.put(new Student(4), 4);
        map.put(new Student(5), 5);
        map.put(new Student(6), 6);
        map.put(new Student(7), 8);
        map.put(new Student(8), 8);
        map.put(new Student(9), 9);
        map.put(new Student(10), 10);
    }
}

class Student {
    int no;

    public Student(int no) {
        this.no = no;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
