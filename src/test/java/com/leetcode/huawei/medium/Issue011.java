package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Issue011 {

    @Test
    public void testFun() {
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        // sort
        Arrays.sort(nums);
        // 3 foreach
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t = -nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] > t) {
                    k--;
                } else if (nums[j] + nums[k] < t) {
                    j++;
                } else {
                    // find
                    List<Integer> ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    result.add(ans);
                    // 去除临近相同的元素
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
