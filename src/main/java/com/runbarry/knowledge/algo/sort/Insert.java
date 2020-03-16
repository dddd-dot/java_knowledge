package com.runbarry.knowledge.algo.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author xbuding
 * @version 1.0
 * @since 2020/3/12
 */
public class Insert {

    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            // 用第二个值 作为比较对象， 第一个 当做已经排好的数
            int value = arr[i];
            // 获取 比较对象的前者 坐标
            int j = i - 1;
            for (; j >= 0; j--) {
                // 比较对象 不停 向前 比较，如果前者比 对象大，前者的往后移动一位
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    // 直到前者比比较对象小
                    break;
                }
            }
            // 将 比较对象好 放进 比较后应该处于的位置
            arr[j + 1] = value;
        }
        System.err.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 3, 1};
        sort(arr);
    }
}
