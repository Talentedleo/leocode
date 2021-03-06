package com.leetcode.exam.medium;

import org.junit.Test;

public class Issue003 {

    //198. 打家劫舍
    @Test
    public void test() {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("result: " + rob(nums));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }
}

