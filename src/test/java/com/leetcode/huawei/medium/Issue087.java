package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. 重复的DNA序列
 *
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 */
public class Issue087 {

    @Test
    public void testFun() {
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<11) return new ArrayList<>();
        int f = 1048575;
        char[] cs = s.toCharArray();
        int tmp = 0;
        for(int i=0;i<10;i++) {
            tmp<<=2;
            tmp|=key(cs[i]);
        }
        Set<Integer> set = new HashSet<>();
        set.add(tmp);
        Set<String> ans = new HashSet<>();

        for(int i=10;i<cs.length;i++){
            tmp <<=2;
            tmp |= key(cs[i]);
            int p = tmp & f;
            if(set.contains(p)){
                ans.add(cast(p));
            }else set.add(p);
        }
        return new ArrayList<>(ans);
    }
    private int key(char c){
        switch(c){
            case 'A':return 0;
            case 'C':return 1;
            case 'G':return 2;
            case 'T':return 3;
        }
        return -1;
    }
    private char val(int c){
        switch(c){
            case 0:return 'A';
            case 1:return 'C';
            case 2:return 'G';
            case 3:return 'T';
        }
        return 'm';
    }
    private String cast(int val){
        char[] cs = new char[10];
        for(int i=9;i>-1;i--){
            cs[i] = val(3 & val);
            val>>=2;
        }
        return new String(cs);
    }

}
