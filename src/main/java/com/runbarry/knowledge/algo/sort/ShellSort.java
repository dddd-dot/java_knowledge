package com.runbarry.knowledge.algo.sort;

import java.util.Arrays;

/**
 * 希尔排序 插入排序的优化
 * 有趣的图解： @link https://blog.csdn.net/qq_39207948/article/details/80006224
 *
 * @author xbuding
 * @version 1.0
 * @since 2020/3/13
 */
public class ShellSort {

    public static void sort(int[] array) {
        int n = array.length;
        int gap = n / 2;
        while (gap > 0) {
            System.err.println("gap = " + gap + " ---before--- " + Arrays.toString(array));
           /* for (int j = gap; j < n; j++) {
                int i = j;
                int frontIndex = i - gap;
                // 将按 gap 增量作为一组数组，按照大小进行排序
                while (i >= gap && arr[frontIndex] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[frontIndex];
                    arr[frontIndex] = temp;
                    i -= gap;
                }
            }*/

            for (int i = 0; i < gap; i++) {
                //这个循环里其实就是一个插入排序
                for (int j = i + gap; j < array.length; j += gap) {
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }


            // 随着 增量 gap 越来越小 数组的 有序度 越来越高 当 gap = 1 时，相当于进行一次插入排序即可完成排序
            System.err.println("gap = " + gap + " ----after--- " + Arrays.toString(array));
            //增量每次减半
            gap = gap / 2;
        }
        System.out.println("结果 " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 5, 1, 23, 6, 78, 34, 23, 4, 5, 78, 34, 65, 32, 65, 76, 32, 76, 1, 9};
        sort(arr);
    }

}
