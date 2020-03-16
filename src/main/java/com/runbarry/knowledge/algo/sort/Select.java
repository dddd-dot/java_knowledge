package com.runbarry.knowledge.algo.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author xbuding
 * @version 1.0
 * @since 2020/3/13
 */
public class Select {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int maybeSmall = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (maybeSmall > arr[j]) {
                    int bigger = maybeSmall;
                    maybeSmall = arr[j];
                    arr[j] = bigger;
                }
            }
            arr[i] = maybeSmall;
        }
        System.err.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 3, 1};
        sort(arr);
    }
}
