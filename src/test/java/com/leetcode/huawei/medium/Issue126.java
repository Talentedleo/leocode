package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 *
 */
public class Issue126 {

    @Test
    public void testFun() {

    }

    public int coinChange(int[] coins, int amount) {
        //初始化dp表，最大值目标最大值 + 1,相当于无穷大
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //初始化dp表里面数据全部为max
        Arrays.fill(dp, max);
        //已知目标金额为0的时候，需要0个硬币
        dp[0] = 0;
        //遍历1到amount需要多少硬币
        for(int i = 1; i <= amount; i++) {
            //遍历所有硬币
            for(int coin : coins) {
                if(i - coin < 0) continue;
                //子问题dp[i-coin]加1枚硬币就是当前硬币的需要个数
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        //如果目标金额的一直没有答案返回-1
        return dp[amount] == max ? -1 : dp[amount];
    }

}
