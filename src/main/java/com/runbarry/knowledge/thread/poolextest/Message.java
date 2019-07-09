package com.runbarry.knowledge.thread.poolextest;

import lombok.Data;

/**
 * @author xbuding
 * @version 1.0
 * @since 2019/7/9
 */
@Data
public class Message {
    private Integer id;
    private String body;

    public Message(Integer id, String body) {
        this.id = id;
        this.body = body;
    }
}
