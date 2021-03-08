package com.leetcode.exam.medium;

import org.junit.Test;

public class Issue008 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //104. 二叉树的最大深度
    @Test
    public void test() {
//        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
//        System.out.println("result: " + countComponents(input, 3));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node) {
       if (null == node) return 0;
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
