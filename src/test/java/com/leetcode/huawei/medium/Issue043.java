package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Issue043 {

    @Test
    public void testFun() {
    }

    private List<List<Integer>> res;
    private int k,n;
    public List<List<Integer>> combine(int n, int k) {
        res=new ArrayList<>();
        this.k=k;
        this.n=n;
        if(k>n) return res;
        trace(new ArrayList<>(),1,0);
        return res;
    }

    private void trace(List<Integer> list,int index,int count){
        if(count==k){
            res.add(new ArrayList<>(list));
            return;
        }
        if((n-index+1)<k-count) return;
        for (int i=index;i<=n;i++){
            list.add(i);
            trace(list,i+1,count+1);
            list.remove(list.size()-1);
        }
    }

}
