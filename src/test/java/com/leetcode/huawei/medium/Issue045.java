package com.leetcode.huawei.medium;

import org.junit.Test;

/**
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 */
public class Issue045 {

    @Test
    public void testFun() {
    }

    private boolean find;  // 定义为成员变量，方便以下两个成员方法使用和修改

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        find = false;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                backtracking(i, j, board, word, visited, 0);  // 从左上角开始遍历棋盘每个格子
            }
        }
        return find;
    }

    /**
     * i,j,board：棋盘格及当前元素的坐标
     * word: 要搜索的目标单词
     * visited：记录当前格子是否已被访问过
     * pos: 记录目标单词的字符索引，只有棋盘格字符和pos指向的字符一致时，才有机会继续搜索接下来的字符；如果pos已经过了目标单词的尾部了，那么便说明找到目标单词了
     */
    public void backtracking(int i, int j, char[][] board, String word, boolean[][] visited, int pos){
        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
        if(i<0 || i>= board.length || j<0 || j >= board[0].length || visited[i][j] || find
                || board[i][j]!=word.charAt(pos))  return;

        if(pos == word.length()-1){
            find = true;
            return;
        }

        visited[i][j] = true;  // 修改当前节点状态
        backtracking(i+1, j, board, word, visited, pos+1);  // 遍历子节点
        backtracking(i-1, j, board, word, visited, pos+1);
        backtracking(i, j+1, board, word, visited, pos+1);
        backtracking(i, j-1, board, word, visited, pos+1);
        visited[i][j] = false; // 撤销修改
    }

}
