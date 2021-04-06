package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Issue166 {

    @Test
    public void testFun() {

    }

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        int leftBracket = n, rightBracket = n;
        this.res = new ArrayList<>();
        dfs(leftBracket, rightBracket, new StringBuilder());
        return res;
    }

    private void dfs(int leftBracket, int rightBracket, StringBuilder sb) {
        if (leftBracket == 0 && rightBracket == 0) {
            res.add(sb.toString());
            return;
        }

        if (leftBracket > rightBracket) {
            return;
        }

        if (leftBracket > 0) {
            sb.append("(");
            dfs(leftBracket - 1, rightBracket, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracket > 0) {
            sb.append(")");
            dfs(leftBracket, rightBracket - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
