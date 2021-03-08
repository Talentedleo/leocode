package com.leetcode.exam.medium;

public class Issue002 {

    //    486. 预测赢家
    public static void main(String[] args) {
        Issue002 test = new Issue002();

        int[] nums = {1, 5, 2};
        System.out.println("result: " + test.predicateTheWinner(nums));
    }

    public boolean predicateTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int s = nums.length; s >= 0; s--) {
            for (int e = s + 1; e < nums.length; e++) {
                int a = nums[s] - dp[s + 1][e];
                int b = nums[e] - dp[s][e - 1];
                dp[s][e] = Math.max(a, b);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
