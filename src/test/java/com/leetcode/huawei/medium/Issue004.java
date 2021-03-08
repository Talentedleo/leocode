package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 221. 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 */
public class Issue004 {

    @Test
    public void testFun() {
    }

    // 暴力解法
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == '1') max = Math.max(max, function(matrix, i, j));
        return max;
    }

    public int function(char[][] matrix, int i, int j) {
        int m = 0;
        for (; m + j < matrix[0].length && m + i < matrix.length; m++) {
            for (int p = j; p <= j + m; p++)
                if (matrix[m+i][p] != '1') return m * m;
            for (int q = i; q < i + m; q++)
                if (matrix[q][m+j] != '1') return m * m;
        }
        return m * m;
    }

}
