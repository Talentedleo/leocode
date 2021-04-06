package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 400. 第 N 位数字
 *
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 *
 *  
 *
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 * 示例 2：
 *
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 */
public class Issue146 {

    @Test
    public void testFun() {

    }

    public int findNthDigit(int n) {
        long[] a = {10,90,900,9000,90000,900000,9000000,90000000,900000000};
        for(int i=1;i<a.length;i++){
            a[i] *= (i+1);
            a[i] += a[i-1];
        }
        // System.out.println(Arrays.toString(a));
        //也可以直接换成这个数组。
        //[10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890, 8888888890]
        int i=0;
        for(;i<a.length;i++){
            if(a[i]>n){
                break;
            }
        }
        if(i==0){
            return n;
        }
        int b = n-(int)a[i-1];
        int c = b/(i+1);
        int d = b%(i+1);
        int num = (int)Math.pow(10,i);
        num += c;
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return (int)sb.charAt(d)-'0';
    }
}
