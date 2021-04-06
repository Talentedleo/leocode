package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Stack;

/**
 * 面试题 16.26. 计算器
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 */
public class Issue162 {

    @Test
    public void testFun() {

    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        char opt = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch))
                num = num * 10 + (ch - '0');

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (opt == '+')
                    stack.push(num);
                else if (opt == '-')
                    stack.push(-num);
                else if (opt == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);

                num = 0;
                opt = ch;
            }
        }

        int res = 0;
        while (!stack.isEmpty())
            res += stack.pop();

        return res;
    }

}
