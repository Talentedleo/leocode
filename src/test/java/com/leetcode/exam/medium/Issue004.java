package com.leetcode.exam.medium;

import org.junit.Test;

public class Issue004 {

    //383. 赎金信
    @Test
    public void test() {
        System.out.println("result: " + canConstruct("ac", "abcd"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        int index;
        for (char c : ransomNote.toCharArray()) {
            index = sb.indexOf(String.valueOf(c));
            if (index >= 0) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return true;
    }

}
