package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 378. 有序矩阵中第 K 小的元素
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *  
 *
 * 提示：
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 */
public class Issue140 {

    @Test
    public void testFun() {

    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length-1;
        int l = matrix[0][0], r = matrix[n][n];
        while(l < r) {
            int mid = l + (r-l)/2;
            int count = countNoMoreThanMid(matrix, mid, n);
            if(count < k) l = mid+1;
            else r = mid;
        }
        return r;
    }

    public int countNoMoreThanMid(int[][] matrix, int mid, int n) {
        int x = n, y = 0, count = 0;
        while(x >= 0 && y <= n) {
            if(matrix[x][y] <= mid) {
                count += x + 1;
                ++ y;
            }else {
                -- x;
            }
        }
        return count;
    }

}
