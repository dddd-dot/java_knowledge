package com.runbarry.knowledge.algo.sort;

import java.util.Arrays;

/**
 * 快排
 * quickSort1 使用的是填坑法 @link https://juejin.im/post/5b55660ee51d4519202e2003
 * quickSort2 两两置换法 @link https://wiki.jikexueyuan.com/project/easy-learn-algorithm/fast-sort.html
 * quickSort1 更容易理解
 *
 * @author xbuding
 * @version 1.0
 * @since 2020/3/16
 */
public class QuickSort {

    /**
     * 0 9
     * [5, 1, 2, 4, 3, 6, 9, 7, 10, 8]
     * 0 4
     * [3, 1, 2, 4, 5, 6, 9, 7, 10, 8]
     * 0 3
     * [2, 1, 3, 4, 5, 6, 9, 7, 10, 8]
     * 0 1
     * [1, 2, 3, 4, 5, 6, 9, 7, 10, 8]
     * 6 9
     * [1, 2, 3, 4, 5, 6, 8, 7, 9, 10]
     * 6 7
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort1(int[] arr, final int left, final int right) {
        if (left >= right) {
            return;
        }
        int low = left, high = right;
        int value = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= value) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (low < high && arr[low] < value) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = value;
        System.err.println(left + " " + right);
        System.err.println(Arrays.toString(arr));
        quickSort1(arr, left, low - 1);
        quickSort1(arr, low + 1, right);
    }

    /**
     * 0 9
     * [3, 1, 2, 5, 4, 6, 9, 7, 10, 8]
     * 0 4
     * [2, 1, 3, 5, 4, 6, 9, 7, 10, 8]
     * 0 1
     * [1, 2, 3, 5, 4, 6, 9, 7, 10, 8]
     * 3 4
     * [1, 2, 3, 4, 5, 6, 9, 7, 10, 8]
     * 6 9
     * [1, 2, 3, 4, 5, 6, 8, 7, 9, 10]
     * 6 7
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = doSort(arr, left, right);
        System.err.println(left + " " + right);
        System.err.println(Arrays.toString(arr));
        quickSort2(arr, left, middle - 1);
        quickSort2(arr, middle + 1, right);
    }

    private static int doSort(int[] arr, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int value = arr[left];
        int startIndex = left;
        while (left != right) {
            if (arr[right] < value) {
                boolean isBreak = false;
                while (!isBreak) {
                    left++;
                    if (left == right) {
                        break;
                    }
                    if (arr[left] > value) {
                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                        isBreak = true;
                    }
                }
            } else {
                right--;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = value;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int left = 0;
        int right = arr.length - 1;
        quickSort2(arr, left, right);
    }
}
