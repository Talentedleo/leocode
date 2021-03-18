package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 130. 被围绕的区域
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class Issue066 {

    @Test
    public void testFun() {
    }

    int row,col;
    public void solve(char[][] board) {
        if(board==null||board.length==0) return;//先判断一下特殊情况
        row=board.length;
        col=board[0].length;
        //遍历一遍整个矩阵，先找出所有边界上的o进行dfs变成*，之后将所有的o变成x,*变成o
        for(int i=0;i<row;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][col-1]=='O') dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[row-1][j]=='O') dfs(board,row-1,j);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='*') board[i][j]='O';
            }
        }
    }
    //从边界上的o出发进行dfs，这些o最后不会变成x，我们先将它们标记成其他符号，比如‘*’
    public void dfs(char[][]board,int i,int j){
        if(i<0||i>=row||j<0||j>=col||board[i][j]!='O') return;//递归结束的条件(边界+值)
        board[i][j]='*';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

}
