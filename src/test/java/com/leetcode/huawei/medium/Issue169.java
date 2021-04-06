package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.02. 迷路的机器人
 *
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 *
 *
 */
public class Issue169 {

    @Test
    public void testFun() {

    }

    List<List<Integer>> temp;
    List<List<Integer>> res;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        temp = new ArrayList();
        res = new ArrayList();
        boolean[][] visted = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        dfs(obstacleGrid, 0, 0, visted);
        return res;
    }

    private void dfs(int[][] grids, int r, int c, boolean[][] visted) {
        if (r < 0 || r >= grids.length || c < 0 || c >= grids[0].length || grids[r][c] == 1) {
            return;
        }
        if (visted[r][c]) {
            grids[r][c] = 1;
            return;
        }
        visted[r][c] = true;
        temp.add(new ArrayList(Arrays.asList(r, c)));
        if (r == grids.length - 1 && c == grids[0].length - 1) {
            res = new ArrayList(temp);
            return;
        }
        dfs(grids, r, c + 1, visted);
        dfs(grids, r + 1, c, visted);
        temp.remove(temp.size() - 1);
    }

}
