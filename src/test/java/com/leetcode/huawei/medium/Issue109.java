package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 264. 丑数 II
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 */
public class Issue109 {

    @Test
    public void testFun() {

    }

    public int nthUglyNumber(int n) {
        //方法一：超时
        // if(n <= 5) return n;
        // Set<Integer> set = new HashSet<>();
        // for(int i = 1; i <= 5; i++) {
        //     set.add(i);
        // }

        // int num = 6;
        // while(set.size() < n-1) {
        //     if((num%2==0 && set.contains(num/2)) || (num%3==0 && set.contains(num/3)) || (num%5==0 && set.contains(num/5))) {
        //         set.add(num);
        //     }
        //     num++;
        // }

        // while(true) {
        //     if((num%2==0 && set.contains(num/2)) || (num%3==0 && set.contains(num/3)) || (num%5==0 && set.contains(num/5))) {
        //         return num;
        //     }
        //     num++;
        // }

        //方法二：三指针
        int two = 0, three = 0, five = 0;
        int[] temp = new int[n];
        temp[0] = 1;
        for(int i = 1; i < n; i++) {
            int a = temp[two]*2, b = temp[three]*3, c = temp[five]*5;
            int res = Math.min(Math.min(a, b), c);
            if(res == a) {
                two++;
            }
            if(res == b) {
                three++;
            }
            if(res == c){
                five++;
            }
            temp[i] = res;
        }

        return temp[n-1];
    }

}
