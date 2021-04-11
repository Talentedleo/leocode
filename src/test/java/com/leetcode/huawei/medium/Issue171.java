package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1481. 不同整数的最少数目
 *
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 *
 */
public class Issue171 {

    @Test
    public void testFun() {

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                hm.replace(arr[i],hm.get(arr[i])+1);
            }
            else
            {
                hm.put(arr[i],1);
            }
        }
        if(k==0) return hm.size();              //如果k为0直接返回所有不同整数个数
        int[] val = new int[hm.size()];
        int a=0;
        for(int key:hm.keySet()){
            val[a++] = hm.get(key);
        }

        Arrays.sort(val);                       //排序后即可从小到大依次用K来减
        int i = 0;
        for(i=0;i<val.length;i++){
            if(k-val[i]>=0){
                k = k-val[i];
            }
            else break;
        }
        return val.length - i;                   //返回被k减后剩余的不同整数个数
    }

}
