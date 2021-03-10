package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 */
public class Issue019 {

    @Test
    public void testFun() {
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }

        // 第1步，寻找最后一个正序，寻找方法：从后向前找。
        int i = n - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        // i==0,表示未找到最后的排列
        if (i != 0) {
            // 第2步，从后往前找一个比array[i-1]大的第一个数字。
            int j = n - 1;
            while (j > i && nums[j] <= nums[i - 1]) {
                j--;
            }

            // 第3步，交换array[i-1],array[j]
            int tmp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = tmp;
        }

        // 第4步，把i及其后面的序列反序。
        while (i < n - 1) {
            int tmp = nums[i];
            nums[i] = nums[n - 1];
            nums[n - 1] = tmp;
            i++;
            n--;
        }
    }

}
