package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 面试题 17.14. 最小K个数
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 */
public class Issue161 {

    @Test
    public void testFun() {

    }

    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex, int k) {
        if (startIndex >= endIndex) {
            return;
        }
        int partitionIndex = quickSortPartition(arr, startIndex, endIndex);
        if (partitionIndex == k) {
            return;
        }
        if (k < partitionIndex) {
            quickSort(arr, startIndex, partitionIndex - 1, k);
        } else {
            quickSort(arr, partitionIndex + 1, endIndex, k);
        }
    }

    private static int quickSortPartition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int i = startIndex;
        for (int j = startIndex; j <= endIndex - 1; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[endIndex];
        arr[endIndex] = arr[i];
        arr[i] = temp;
        return i;
    }

}
