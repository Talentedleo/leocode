package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.Arrays;

public class Issue011 {

    //1196. 最多可以买到的苹果数量
    @Test
    public void test() {
//        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
//        System.out.println("result: " + countComponents(input, 3));
    }

    public int maxNumberOfApples(int[] arr) {
        int maxCapacity = 5000;

        Arrays.sort(arr);

        int num = 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;

            if (sum <= maxCapacity) {
                num++;
            }
        }

        return num;

    }
}
