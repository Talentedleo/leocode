package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *  
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 *
 */
public class Issue117 {

    @Test
    public void testFun() {

    }

    class NumMatrix {
        int[][] matrix;
        int[][] presum;
        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            int m = matrix.length;
            int n = 0;
            if (m != 0) n = matrix[0].length;
            presum = new int[m][n+1];
            for (int i = 0 ; i < m ; i++) {
                for (int j = 1 ; j < n+1 ; j++) {
                    presum[i][j] = presum[i][j-1] + matrix[i][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1 ; i <= row2 ; i++) {
                sum += presum[i][col2+1] - presum[i][col1];
            }
            return sum;
        }
    }

}
