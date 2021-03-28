package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 253. 会议室 II
 *
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 *
 */
public class Issue107 {

    @Test
    public void testFun() {

    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms=0, activeMeeting = 0;
        int i=0,j=0;
        while(i<intervals.length && j<intervals.length){
            if(start[i]<end[j]){
                activeMeeting++;
                i++;
            }else{
                activeMeeting--;
                j++;
            }
            rooms = Math.max(rooms,activeMeeting);
        }
        return rooms;

    }

}
