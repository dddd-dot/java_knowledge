package com.runbarry.knowledge.gc.oomdumpheap.oom;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 測試輸出oom heap快照 -Xms20m -Xmx20m  -XX:HeapDumpPath=C:\Users\Administrator\Desktop\dump -XX:+HeapDumpOnOutOfMemoryError
 *
 * output :  java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to C:\Users\Administrator\Desktop\dump\java_pid10344.hprof ...
 * Heap dump file created [30101548 bytes in 0.077 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.Arrays.copyOf(Arrays.java:3181)
 * 	at java.util.ArrayList.grow(ArrayList.java:261)
 * 	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
 * 	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
 * 	at java.util.ArrayList.add(ArrayList.java:458)
 * 	at com.runbarry.knowledge.gc.OomTest.main(OomTest.java:19)
 *
 * @author xbuding
 * @version 1.0
 * @since 2019/8/1
 */
@Slf4j
public class OomTest {

    public static void main(String[] args) {
        List<MyObject> list = new ArrayList<>();
        while (true) {
            list.add(new MyObject());
        }
    }
}
