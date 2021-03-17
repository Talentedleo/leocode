package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class Issue064 {

    @Test
    public void testFun() {
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //记录矩阵的行数
        int row = triangle.size();

        //记录最后一行数组的值（行数和列数相等）
        int[] cache = new int[row];
        for (int k = 0; k < row; k++) {
            cache[k] = triangle.get(row - 1).get(k);
        }

        //从倒数第二行数组开始遍历
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                cache[j] = Math.min(cache[j], cache[j + 1])
                        + triangle.get(i).get(j);
            }
        }
        return cache[0];
    }

//初始状态
// [
// [2],
// [3,4],
// [6,5,7],
// [4,1,8,3]]
//cache = []

// 初始化缓存数组后
// cache = [4,1,8,3]

//第一次j遍历完成之后
// [6,5,7]
// [4,1,8,3] ，这是初始化后的缓存数组
// cache = [7,6,10,3]
// 其中 7 = min(4,1)+6, 6 = min(1,8)+5, 10 = min(8,3)+7,3不是计算所得

//第二次j遍历完成之后
// [3,4]
// [7,6,10,3] 这是第一次计算之后的缓存数组
// cache = [9,10,10,3]
//其中 9 =  min(7,6)+3,10 = min(6,10)+4,10,3不是这次计算所得

//第三次j遍历完成之后
//[2]
//[9,10,10,3]
// cache = [11,10,10,3]
// 其中 9 = min(11,10)+2,10,10,3不是计算所得
//返回cache[0]


}
