package com.runbarry.knowledge.filter.bloom;


/**
 * -Xms64m -Xmx64m -XX:+PrintHeapAtGC
 *
 * @author xbuding
 * @version 1.0
 * @since 2019/11/22
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        /*long star = System.currentTimeMillis();
        BloomFilters bloomFilters = new BloomFilters(10000000);
        for (int i = 0; i < 10000000; i++) {
            bloomFilters.add(i + "");
        }
        Assert.assertTrue(bloomFilters.check(1 + ""));
        Assert.assertTrue(bloomFilters.check(2 + ""));
        Assert.assertTrue(bloomFilters.check(3 + ""));
        Assert.assertTrue(bloomFilters.check(999999 + ""));
        Assert.assertTrue(bloomFilters.check(400230340 + ""));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));*/

        /*long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }
        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));*/
    }

}
