package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 *
 */
public class Issue155 {

    @Test
    public void testFun() {

    }

    /**
     * 这个题属于技巧题 首先仔细看输入的给定的数组值 该值的区间为 1 ≤ a[i] ≤ n
     * 这其实是这道题解题的关键点，好好利用这个信息。 某些元素出现了两次，
     * 而一些其他的元素只出现了1次，我们可以利用这些元素在出现次数上面的不一样做文章。
     *
     * 仔细观察发现1 ≤ a[i] ≤ n 这个条件，正好和我们数组的下标差1，我们可以按照数值
     * 来遍历数组，那么在数组中具有相同值的元素，会被经过两次，那么我们只要想出一种方式
     * 在这个遍历结束后可以区分，哪些元素被经过了多次即可，由于数组元素具有1 ≤ a[i] ≤ n
     * 这样的范围，那其实我们当每次经过一个元素时，给他加上n，当遍历结束时，我们再次遍历数组
     * 那些数值超过2n的元素索引+1，对应的就是我们的出现了两次的元素。
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) ret.add(i+1);
        }
        return ret;
    }
}
