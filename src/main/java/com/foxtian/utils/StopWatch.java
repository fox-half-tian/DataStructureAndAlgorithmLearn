package com.foxtian.utils;

import java.util.HashMap;
import java.util.UUID;

/**
 * Description: 计时器
 *
 * @Author 狐狸半面添
 * @Create 2024/8/3 17:29
 * @Version 1.0
 */
public class StopWatch {

    private final HashMap<String, Task> tasks;

    private final String defaultTaskName;

    public StopWatch() {
        tasks = new HashMap<>();
        defaultTaskName = UUID.randomUUID().toString();
        tasks.put(defaultTaskName, new Task());
    }

    private Task getTask(String taskName) {
        Task task = tasks.get(taskName);
        if (task == null) {
            throw new RuntimeException("未能找到名称为 " + taskName + " 的任务");
        }
        return task;
    }

    /**
     * 停止计时
     */
    public void stop() {
        stop(defaultTaskName);
    }

    public void stop(String taskName) {
        Task task = getTask(taskName);
        task.stop();
    }

    /**
     * 开始计时
     */
    public void start() {
        start(defaultTaskName);
    }

    public void start(String taskName) {
        Task task = tasks.get(taskName);
        if (task == null) {
            task = new Task();
        }
        tasks.put(taskName, task);
        task.start();
    }


    /**
     * 重置计时
     */
    public void reset() {
        reset(defaultTaskName);
    }

    /**
     * 重置计时
     */
    public void reset(String taskName) {
        Task task = getTask(taskName);
        task.reset();
    }

    /**
     * 读取从开始时间起已经过去的时间，单位 ms
     */
    public long elapsedMilliseconds() {
        return elapsedMilliseconds(defaultTaskName);
    }

    public long elapsedMilliseconds(String taskName) {
        Task task = getTask(taskName);
        return task.elapsedMilliseconds();
    }

    private static class Task {
        private long startTime;
        private long stopTime;


        /**
         * 停止计时
         */
        public void stop() {
            if (startTime == 0) {
                throw new RuntimeException("计时器未设置开始时间");
            }
            if (stopTime != 0) {
                throw new RuntimeException("计时器已终止过");
            }
            stopTime = System.currentTimeMillis();
        }

        /**
         * 开始计时
         */
        public void start() {
            if (startTime != 0) {
                throw new RuntimeException("计时器已开始过");
            }
            startTime = System.currentTimeMillis();
        }

        /**
         * 重置计时
         */
        public void reset() {
            startTime = 0;
            stopTime = 0;
        }

        /**
         * 读取从开始时间起已经过去的时间，单位 ms
         */
        public long elapsedMilliseconds() {
            if (startTime == 0) {
                throw new RuntimeException("从未开始计时");
            }
            return stopTime != 0 ? stopTime - startTime : startTime - System.currentTimeMillis();
        }
    }
}
