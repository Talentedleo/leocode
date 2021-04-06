package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 424. 替换后的最长重复字符
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class Issue151 {

    @Test
    public void testFun() {

    }

    // 滑动窗口
    public int characterReplacement(String str, int k) {
        int n = str.length();
        char[] s = str.toCharArray();
        int res = 0;
        for(char c = 'A'; c <='Z'; c++){
            int count = 0;
            for(int i = 0 , j = 0;j < n;j ++){
                if(s[j] == c){
                    count ++;
                }
                while(j - i + 1 - count > k){
                    //收敛窗口,找到不是c的下一个位置贡献出一个k
                    if(s[i] == c){
                        count --;
                    }
                    i ++;
                }
                //这个是满足条件的
                res = Math.max(res,j - i + 1);
            }
        }
        return res;
    }

}
