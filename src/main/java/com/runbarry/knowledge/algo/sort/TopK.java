package com.runbarry.knowledge.algo.sort;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xbuding
 * @version 1.0
 * @since 2020/3/25
 */
public class TopK {

    int[] arr = {8, 9, 10, 7, 6, 2, 4, 3, 1, 5};

    static class MaxheapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    /**
     * 利用优先队列实现 TopK
     */
    @Test
    public void testTok5() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MaxheapComparator());
        for (Integer integer : arr) {
            queue.add(integer);
        }
        for (int i = 0; i < 5; i++) {
            System.err.println("top" + (i + 1) + "=" + queue.poll());
        }
        /*while (!queue.isEmpty()) {
            System.err.println(queue.poll());
        }*/
    }

    /**
     * 使用 小根堆 实现 TopK 内存小的时候非常适合用只需要维护 大小K的 小根堆即可，减少内存需求
     */
    @Test
    public void testMiniHeapTok5() {
        int[] arr = {8, 9, 10, 7, 6, 2, 4, 3, 1, 5};
        int k = 5;
        for (int i = k / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustMinHeap(arr, i, k);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[0] < arr[k]) {
                arr[0] = arr[k];
                adjustMinHeap(arr, i, k);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustMinHeap(arr, 0, i);
        }
        for (int i = 0; i < 5; i++) {
            System.err.println("top" + (i + 1) + "=" + arr[i]);
        }
    }

    /**
     * 调整小顶堆
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustMinHeap(int[] arr, int i, int length) {
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] > arr[k + 1]) {
                k++;
            }
            //如果子节点小于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] < temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }
}
