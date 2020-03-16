package com.runbarry.knowledge.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author xbuding
 * @version 1.0
 * @since 2020/3/12
 */
public class Bubble {

    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean isChange = false;
            // n - i - 1 这里减少 不需要的比较次数
            for (int j = 0; j < n - i - 1; j++) {
                // 如果前者比后者大，交换位置  ---- 冒泡，所以 每次循环(n - i - 1)可以少比较一次后面的数。
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    // 标识当前循环 出现 位置变动
                    isChange = true;
                }
            }
            //如果没有任务位置变动，证明序列已经排好，退出循环
            if (!isChange) {
                break;
            }
        }
        System.err.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 3, 1};
        System.err.println(Arrays.toString(arr));
        sort(arr);
    }
}
