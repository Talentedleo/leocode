package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 */
public class Issue133 {

    @Test
    public void testFun() {

    }

    public int integerBreak(int n) {
        int ans = 1;
        if(n<4) return n-1; // n <  4时, 两数之和大于两数之积
        while(n>4){  // n=4时,3*1<3+1,但当n=5时,3*2>3+2
            n -= 3;
            ans *= 3;
        }
        return ans * n;  //最后返回的时候记得乘上最后剩下的n
    }

}
