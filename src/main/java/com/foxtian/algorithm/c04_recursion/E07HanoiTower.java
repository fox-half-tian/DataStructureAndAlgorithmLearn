package com.foxtian.algorithm.c04_recursion;

import java.util.LinkedList;

/**
 * Description: 汉诺塔问题
 *
 * @Author 狐狸半面添
 * @Create 2024/8/5 22:15
 * @Version 1.0
 */
public class E07HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    public static void main(String[] args) {
        init(3);
        move(3, a, b, c);
    }

    public static void move(int n, LinkedList<Integer> from, LinkedList<Integer> mid, LinkedList<Integer> to) {
        if (n == 0) {
            return;
        }
        move(n - 1, from, to, mid);
        to.addLast(from.removeLast());
        print(from, to);
        move(n - 1, mid, from, to);
    }

    static void print(LinkedList<Integer> from, LinkedList<Integer> to) {
        System.out.println(getName(from) + "->" + getName(to));
    }

    static String getName(LinkedList<Integer> list) {
        if (list == a) {
            return "a";
        } else if (list == b) {
            return "b";
        } else if (list == c) {
            return "c";
        } else {
            return null;
        }
    }
}
