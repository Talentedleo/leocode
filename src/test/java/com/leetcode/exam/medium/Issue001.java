package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.Arrays;


public class Issue001 {

    //667. 优美的排列 II
    @Test
    public void test01() {
        System.out.println("result: " + Arrays.toString(constructArray(5, 2)));
    }

    private int[] constructArray(int n, int k) {
        int[] result = new int[n];
        result[0] = n;
        for (int i = k + 1, temp = n - k - 1; i < n; i++, temp--) result[i] = temp;
        for (int i = 1, flag = -1, temp = k; i < k + 1; i++) {
            result[i] = result[i - 1] + temp * flag;
            flag = -1 * flag;
            temp--;
        }
        return result;
    }
}
