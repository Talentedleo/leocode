package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 */
public class Issue051 {

    @Test
    public void testFun() {
    }

    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        if(n < 4 || n > 12) {
            return ans;
        }
        dfs(s, new StringBuilder(), 0, 0);
        return ans;
    }
    public void dfs(String s, StringBuilder cur, int idx, int dot) {
        int n = s.length();
        int len = cur.length();
        if(idx == n && dot == 4) {
            ans.add(cur.toString());
            return;
        }
        for(int i = idx; i < n; i++) {
            String tmp = s.substring(idx, i + 1);
            if((tmp.length() > 3) ||
                    ((tmp.length() > 1 && tmp.charAt(0) == '0') ||
                            (Integer.valueOf(tmp) > 255) )) {
                continue;
            }
            cur.append(tmp);
            if(i != n - 1) {
                cur.append(".");
            }
            dfs(s, cur, i + 1, dot + 1);
            cur.setLength(len);
        }
    }

}
