package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Issue005 {

    //766. 托普利茨矩阵
    @Test
    public void test() {
        int[][] M = {{1,2},{2,1}};
        System.out.println("result: " + isToeplitzMatrix(M));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> group = new HashMap();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!group.containsKey(r-c)){
                    group.put(r-c, matrix[r][c]);
                } else if (group.get(r-c) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

}
