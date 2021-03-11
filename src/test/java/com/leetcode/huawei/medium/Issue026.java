package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 */
public class Issue026 {

    @Test
    public void testFun() {
    }

    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int[] dp = new int[n -1];
        for(int i = n-2;i >= 0;i--){
            if(i + nums[i] >= n-1){
                dp[i] = 1;
            }else{
                dp[i] = n + 1;//选择尽可能大的数
                int k = Math.min(n - 1,i + nums[i]);
                for(int j = i + 1;j <= k;j++){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
                dp[i]++;
            }
        }
        return dp[0];
    }

}
