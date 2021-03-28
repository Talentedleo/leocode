package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 280. 摆动排序
 *
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 *
 * 示例:
 *
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 *
 */
public class Issue112 {

    @Test
    public void testFun() {

    }

    public void wiggleSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int[] arr = nums.clone();

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int left = 0;
        int right = arr.length-1;
        int index = 0;
        while (left <= right) {
            if (index < arr.length) {
                nums[index] = arr[left];
                index++;
            }

            if (index < arr.length) {
                nums[index] = arr[right];
                index++;
            }

            left++;
            right--;
        }
    }

}
