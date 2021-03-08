package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.Stack;

public class Issue002 {

    //20. 有效的括号
    @Test
    public void test() {
        String s = "()[]{}";
        System.out.println("result: " + isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popStack = stack.pop();
                if (popStack != '(' && c == ')') return false;
                if (popStack != '[' && c == ']') return false;
                if (popStack != '{' && c == '}') return false;
            }
        }
        return stack.isEmpty();
    }
}
