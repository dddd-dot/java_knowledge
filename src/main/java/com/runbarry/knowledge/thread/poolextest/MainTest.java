package com.runbarry.knowledge.thread.poolextest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xbuding
 * @version 1.0
 * @since 2019/7/9
 */
@Slf4j
public class MainTest {

    public static void main(String[] args) {
        LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        /*
          起一个线程充当 提供者
         */
        new Thread(() -> {
            Integer id = 1;
            while (true) {
                Message msg = new Message(id, "msg body");
                queue.offer(msg);
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                id++;
                if (id % 5 == 0) {
                    log.warn("队列中的数据数量 {}", queue.size());
                }
            }
        }).start();


        /**
         * 启动一个数量=1的线程池，执行消费任务
         */
        int threadNum = 1;
        ExecutorService executorService = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("consume-pool-%d").build());
        executorService.execute(new Consumer(queue));
    }
}
