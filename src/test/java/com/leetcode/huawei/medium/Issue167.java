package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 *
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 */
public class Issue167 {

    @Test
    public void testFun() {

    }

    public String[] permutation(String S) {

        List<String> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        boolean[] book = new boolean[arr.length];
        dfs(list, new StringBuilder(), book, arr);

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }

    public void dfs(List<String> res, StringBuilder sb, boolean[] book, char[] arr) {

        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!book[i]) {
                if (i > 0 && arr[i] == arr[i - 1] && !book[i - 1])
                    continue;
                else {
                    sb.append(arr[i]);
                    book[i] = true;
                    dfs(res, sb, book, arr);
                    book[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
