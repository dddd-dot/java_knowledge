package com.runbarry.knowledge.algo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xbuding
 * @version 1.0
 * @since 2020/3/24
 */
public class HeapSort {
    /**
     * 递归处理大根堆
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {100, 20, 73, 56, 21, 78, 34, 10, 8, 98, 40};
        System.out.println("排序前：" + Arrays.toString(arr));
        buildHeap(arr, arr.length);
        System.out.println("排序后：" + Arrays.toString(arr));
    }


    /**
     * 堆化
     *
     * @param arr
     * @param n
     * @param i
     */
    public static void heapify(int[] arr, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (i != max) {
            swap(arr, i, max);
            heapify(arr, n, max);
        }
    }

    /**
     * 建立堆
     *
     * @param arr
     * @param n
     */
    public static void buildHeap(int[] arr, int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * 交换
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * for 处理 大根堆
     */
    @Test
    public void testFor() {
        int[] arr = {100, 20, 73, 56, 21, 78, 34, 10, 8, 98, 40};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素 堆排序
        /*for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }*/

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    /**
     * java优先队列 默认内置 小根堆
     * 想修改成 大跟堆 类实现 Comparator 即可
     */
    @Test
    public void testPriorityMiniHeap() {
        int[] arrForHeap = {35, 45, 25, 50, 30, 40, 15, 20, 10};
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (Integer integer : arrForHeap) {
            minHeap.add(integer);
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }


    @Test
    public void testMiniHeap() {
        int[] arr = {3, 5, 2, 7, 0, 1, 6, 4};
        System.out.println("排序前：" + Arrays.toString(arr));
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustMinHeap(arr, i, arr.length);
        }
        System.out.println("排序后：" + Arrays.toString(arr));
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
