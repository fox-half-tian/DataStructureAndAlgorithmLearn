package com.foxtian.structure.c08_priorityqueue;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/15 21:57
 * @Version 1.0
 */
public class Entry implements Priority {
    String value;
    int priority;

    public Entry(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }
}
