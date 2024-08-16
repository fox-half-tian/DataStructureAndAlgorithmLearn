package com.foxtian.structure.c09_blockqueue;

import com.foxtian.utils.ForeachUtils;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @Author 狐狸半面添
 * @Create 2024/8/16 20:08
 * @Version 1.0
 */
public class BlockingQueueImplTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueImpl<String> blockingQueue = new BlockingQueueImpl<String>(3);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " begin");

                blockingQueue.offer("task1");
                System.out.println(ForeachUtils.getStrByIterator(blockingQueue));
                blockingQueue.offer("task2");
                System.out.println(ForeachUtils.getStrByIterator(blockingQueue));
                blockingQueue.offer("task3");
                System.out.println(ForeachUtils.getStrByIterator(blockingQueue));

                blockingQueue.offer("task4", 5000);
                System.out.println(ForeachUtils.getStrByIterator(blockingQueue));

                System.out.println(System.currentTimeMillis() + " end");
            } catch (Exception e) {

            }
        }, "生产者");
        t1.start();

        Thread.sleep(2000);

        blockingQueue.poll();
    }
}
