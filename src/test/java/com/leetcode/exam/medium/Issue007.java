package com.leetcode.exam.medium;

import org.junit.Test;

import java.util.*;

public class Issue007 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //101. 对称二叉树
    @Test
    public void test() {
//        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
//        System.out.println("result: " + countComponents(input, 3));
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode node1, TreeNode node2) {
        if (null == node1 && null == node2) {
            return true;
        }
        if (null == node1 || null == node2) {
            return false;
        }

        boolean flag = false;
        if (node1.val == node2.val && dfs(node1.left, node2.right) && dfs(node1.right, node2.left)) {
            flag = true;
        }
        return flag;

    }
}
