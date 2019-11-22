package com.runbarry.knowledge.tio.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author xbuding
 * @version 1.0
 * @since 2019/9/18
 */
public class BBTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);
        byteBuffer.put((byte) 3);
        System.err.println(byteBuffer);

        byteBuffer.position(0);
        byteBuffer.limit(1);
        byte b = byteBuffer.get();
        System.err.println(b);
        System.err.println(byteBuffer);

        byteBuffer.position(0);
        byteBuffer.limit(1);
        System.err.println(byteBuffer.get());

    }
}
