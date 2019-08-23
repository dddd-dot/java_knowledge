package com.runbarry.knowledge.gc.oomdumpheap.gclog;


/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+UseSerialGC
 *
 * @author xbuding
 * @version 1.0
 * @since 2019/8/22
 */
public class GcTest {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];

//        System.gc();
    }

    public static void main(String[] args) {
        testAllocation();
    }

    private static final int _1M = 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+PrintGCTimeStamps
     * @param args
     * @throws InterruptedException
     */
    /*public static void main(String[] args) throws InterruptedException {
        byte[] byte1 = new byte[2 * _1M];
        byte[] byte2 = new byte[2 * _1M];
        byte[] byte3 = new byte[2 * _1M];
        byte[] byte4 = new byte[2 * _1M];
        byte[] byte5 = new byte[2 * _1M];

        byte[] byte6 = new byte[5 * _1M];

        byte[] byte7 = new byte[2 * _1M];


    }*/
}
