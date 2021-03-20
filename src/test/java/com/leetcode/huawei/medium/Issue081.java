package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 */
public class Issue081 {

    @Test
    public void testFun() {
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            //这里有个编程技巧
            //因为l<r 所以最后一轮肯定是(r,r+1)
            //那么mid 肯定是取值l 当判断条件是mid与l比时 会出现与自身比 造成出现等于情况 不好判断
            //所以判断条件时mid 与 r比 这样肯定是不同的两个数比
            if (nums[mid] < nums[r]) {  // mid可能为最小值
                r = mid;
            } else { // 没有重复值
                l = mid+1;      // mid肯定不是最小值
            }
        }
        return nums[mid];
    }

}
