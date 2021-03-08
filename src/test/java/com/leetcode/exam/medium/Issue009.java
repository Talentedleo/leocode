package com.leetcode.exam.medium;

import org.junit.Test;

public class Issue009 {

    //392. 判断子序列
    @Test
    public void test() {
//        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
//        System.out.println("result: " + countComponents(input, 3));
    }

    public boolean isSubsequence(String s, String t) {
        int sptr = 0;
        int tptr = 0;

        int slen = s.length() - 1;
        int tlen = t.length() - 1;

        while (sptr <= slen && tptr <= tlen) {
            if (s.charAt(slen) == t.charAt(tlen)) {
                slen--;
                tlen--;
            } else {
                tlen--;
            }

            if (s.charAt(sptr) == t.charAt(tptr)) {
                sptr++;
                tptr++;
            } else {
                tptr++;
            }
        }
        return sptr == slen + 1;
    }
}
