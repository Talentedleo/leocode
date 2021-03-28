package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 254. 因子的组合
 *
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * 示例 4:
 *
 * 输入: 32
 * 输出:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 */
public class Issue108 {

    @Test
    public void testFun() {

    }

    // 方法1: 回溯
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new LinkedList<>(), ans, n);
        return ans;
    }

    private void backtrack(LinkedList<Integer> collector, List<List<Integer>> ans, int n) {
        if (n == 1) return;
        if (collector.size() > 0) {
            ArrayList<Integer> t = new ArrayList<>(collector);
            t.add(n);
            ans.add(t);
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i != 0) continue;
            if (collector.isEmpty() || collector.getLast() <= i) {
                collector.add(i);
                backtrack(collector, ans, n / i);
                collector.remove(collector.size() - 1);
            }
        }
    }

    // 方法2: dfs
    List<List<Integer>>list;
    int n;
    public List<List<Integer>> getFactors2(int n) {

        this.n=n;
        list=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        if(n!=1)
            dfs(1,2,ll);
        return list;

    }
    public void dfs(int sum,int now,List<Integer>ll)
    {
        if(sum==n)
        {
            list.add(new ArrayList<>(ll));
        }
        for(int i=now;i<n;i++)
        {
            int num=sum*i;
            //跳过后面所有的i。
            if(num>n)
                break;
            //换下一个i。
            if(n%num!=0)
                continue;
            ll.add(i);
            dfs(sum*i,i,ll);
            ll.remove(ll.size()-1);
        }
    }

}
