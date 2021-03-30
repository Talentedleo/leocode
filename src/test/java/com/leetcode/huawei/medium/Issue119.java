package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 307. 区域和检索 - 数组可修改
 *
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值更新为 val
 * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
 *  
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 *
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 最多调用 3 * 104 次 update 和 sumRange 方法
 *
 */
public class Issue119 {

    @Test
    public void testFun() {

    }

    class NumArray {

        int[] tree;
        int[] nums;
        int n;

        public void buildTree(int node, int start, int end) {
            if (start == end) {
                tree[node] = nums[start];
                return;
            }
            int mid = (start + end) >> 1;
            int left = node * 2 + 1;
            int right = node * 2 + 2;
            buildTree(left, start, mid);
            buildTree(right, mid + 1, end);
            tree[node] = tree[left] + tree[right];
        }

        public void updateTree(int idx, int node, int val, int start, int end) {
            if (start > end) return;
            if (start == end) {
                nums[idx] = val;
                tree[node] = val;
            } else {
                int mid = (start + end) >> 1;
                int left = node * 2 + 1;
                int right = node * 2 + 2;
                if (idx >= start && idx <= mid)
                    updateTree(idx, left, val, start, mid);
                else
                    updateTree(idx, right, val, mid + 1, end);

                tree[node] = tree[left] + tree[right];
            }
        }

        public int query(int L, int R, int node, int start, int end) {
            if (L > end || R < start) return 0;
            if (start == end) return tree[node];
            if (L <= start && end <= R) return tree[node];
            else {
                int mid = (start + end) >> 1;
                int left = node * 2 + 1;
                int right = node * 2 + 2;
                int ls = query(L, R, left, start, mid);
                int rs = query(L, R, right, mid + 1, end);
                return ls + rs;
            }
        }

        public NumArray(int[] nums) {
            n = nums.length;
            if (n == 0) return;
            this.nums = nums;
            tree = new int[n * 4];
            buildTree(0, 0, n - 1);
        }

        public void update(int i, int val) {
            updateTree(i, 0, val, 0, n - 1);
        }

        public int sumRange(int i, int j) {
            return query(i, j, 0, 0, n - 1);
        }
    }

}
