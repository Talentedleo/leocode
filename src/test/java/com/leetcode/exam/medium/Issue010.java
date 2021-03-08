package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.Arrays;

public class Issue010 {

    //1029. 两地调度
    @Test
    public void test() {
//        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
//        System.out.println("result: " + countComponents(input, 3));
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> c1[0] - c1[1] - (c2[0] - c2[1]));

        int sum = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++) {
            sum += costs[i][0] + costs[i + n][1];
        }

        return sum;

    }
}
