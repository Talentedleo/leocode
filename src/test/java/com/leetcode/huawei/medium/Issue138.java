package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 *
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 */
public class Issue138 {

    @Test
    public void testFun() {

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return res;
        int[] dp = new int[n];
        int numMax = 1;
        int numMaxIndex = 0;

        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j] == 0) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(dp[i] > numMax){
                numMax = dp[i];
                numMaxIndex = i;
            }
        }
        for(int i=numMaxIndex;i>=0;i--){
            if(nums[numMaxIndex]%nums[i] == 0 && dp[i]==numMax){
                res.add(nums[i]);
                numMax--;
            }
        }
        return res;
    }

}
