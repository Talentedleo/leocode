package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 */
public class Issue104 {

    @Test
    public void testFun() {
    }

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> out = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> set : hm.entrySet()) {
            if (set.getValue() > n / 3) {
                out.add(set.getKey());
            }
        }
        return out;
    }

}
