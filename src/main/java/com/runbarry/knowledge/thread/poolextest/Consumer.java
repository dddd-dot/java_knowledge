package com.runbarry.knowledge.thread.poolextest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xbuding
 * @version 1.0
 * @since 2019/7/9
 */
@Slf4j
public class Consumer implements Runnable {

    private LinkedBlockingQueue<Message> queue;

    public Consumer(LinkedBlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = queue.take();
                log.info("消费消息id={}, 消息体:{}", message.getId(), message.getBody());
                if (message.getId() == 10) {
                    throw new RuntimeException("出现异常");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }/* catch (Exception e) {
                // 不 catch 掉 上面的 异常 该线程会进入 wait 状态，不在执行消费任务
                e.printStackTrace();
            }*/
        }
    }
}
