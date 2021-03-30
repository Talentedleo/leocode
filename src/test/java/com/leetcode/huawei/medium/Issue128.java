package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 324. 摆动排序 II
 *
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *
 */
public class Issue128 {

    @Test
    public void testFun() {

    }

    public void wiggleSort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list);

        int edge = (nums.length & 1) == 1 ? nums.length / 2 : nums.length / 2 - 1;
        int left =  edge;
        int right = nums.length - 1;
        int index = 0;
        while (index < nums.length) {
            if (left >= 0) {
                nums[index] = list.get(left);
                left--;
                index++;
            }

            if (index >= nums.length) {
                break;
            }

            if (right > edge) {
                nums[index] = list.get(right);
                right--;
                index++;
            }
        }
    }

}
