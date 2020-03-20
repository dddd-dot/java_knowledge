package com.runbarry.knowledge.algo.sort;

/**
 * @author xbuding
 * @version 1.0
 * @since 2020/3/17
 */
public class BinarySearch {

    /**
     * 最简单的二分 不涉及 数值 重复 (使用递归)
     *
     * @param arr
     * @param searchValue
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch1(int[] arr, int searchValue, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        int temp = arr[middle];
        if (temp < searchValue) {
            return binarySearch1(arr, searchValue, middle + 1, high);
        } else if (temp > searchValue) {
            return binarySearch1(arr, searchValue, low, middle - 1);
        }
        return middle;
    }

    /**
     * 最简单的二分 不涉及 数值 重复 (不使用递归)
     *
     * @param arr
     * @param searchValue
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch2(int[] arr, int searchValue, int low, int high) {
        while (low <= high) {
            int middle = (low + high) / 2;
            int temp = arr[middle];
            if (temp < searchValue) {
                low = middle + 1;
            } else if (temp > searchValue) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /***
     * 优化后的二分查找,上面的无法查找到重复数据的第一个为索引
     * @param arr
     * @param searchValue
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch3(int[] arr, int searchValue, int low, int high) {
        while (low <= high) {
            // 防止数据溢出 int middle = low + ((high - low) >> 1);
            int middle = (low + high) / 2;
            int temp = arr[middle];
            if (temp < searchValue) {
                low = middle + 1;
            } else if (temp > searchValue) {
                high = middle - 1;
            } else {
                if (middle == 0 || arr[middle - 1] != searchValue) {
                    return middle;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param searchValue
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch4(int[] arr, int searchValue, int low, int high) {
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            int temp = arr[middle];
            if (temp >= searchValue) {
                if (middle == 0 || arr[middle - 1] < searchValue) {
                    return middle;
                }
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param arr
     * @param searchValue
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch5(int[] arr, int searchValue, int low, int high) {
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            int temp = arr[middle];
            if (temp <= searchValue) {
                if (middle == 0 || arr[middle + 1] >= searchValue) {
                    return middle;
                }
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.err.println(binarySearch1(arr, 3, 0, arr.length - 1));
        System.err.println(binarySearch2(arr, 3, 0, arr.length - 1));


        int[] arr3 = {0, 1, 3, 3, 4, 5, 6, 7, 8};
        System.err.println(binarySearch3(arr3, 3, 0, arr3.length - 1));

        int[] arr4 = {0, 1, 3, 3, 4, 6, 6, 7, 8};
        System.err.println(binarySearch4(arr4, 5, 0, arr4.length - 1));
        System.err.println(binarySearch4(arr4, 2, 0, arr4.length - 1));
        System.err.println(binarySearch4(arr4, 0, 0, arr4.length - 1));


        int[] arr5 = {3, 5, 6, 8, 9, 10};
        System.err.println(binarySearch5(arr5, 7, 0, arr5.length - 1));
    }

}
