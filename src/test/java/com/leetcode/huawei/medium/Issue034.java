package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 */
public class Issue034 {

    @Test
    public void testFun() {
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length==1){
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(o1, o2)->(o1[0]-o2[0]));
        int min=  intervals[0][0];
        int max = intervals[0][1];
        for(int i = 1;i<=intervals.length-1;i++){
            // 包含
            if(intervals[i][0]>=min && intervals[i][0]<=max){
                // 合并，即取最小的左边，最大的右边
                // 左边已经排好序，不可能小过min
                max = intervals[i][1]>max?intervals[i][1]:max;
            }else{
                // 如果不包含了，则需要把前面的区间加进结果中，并重置min,max
                int[] temp = new int[2];
                temp[0] = min;
                temp[1] = max;
                list.add(temp);
                min = intervals[i][0];
                max = intervals[i][1];
            }
            if(i==intervals.length-1){
                // 最后把最后一个区间也加进去即可。
                int[] temp = new int[2];
                temp[0] = min;
                temp[1] = max;
                list.add(temp);
            }
        }

        int[][] result = new int[list.size()][2];
        for(int i = 0;i<=list.size()-1;i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }

}
