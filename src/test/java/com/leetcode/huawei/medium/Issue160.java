package com.leetcode.huawei.medium;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 */
public class Issue160 {

    @Test
    public void testFun() {

    }

    private List<List<Integer>> res;

    // 回溯 二叉树中和为某一值的路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        backtrack(root, sum, new ArrayList<>());
        return res;
    }

    private void backtrack(TreeNode node, int target, List<Integer> collector) {
        if (node == null) {
            return;
        }
        collector.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(collector));
        } else {
            backtrack(node.left, target, collector);
            backtrack(node.right, target, collector);
        }
        collector.remove(collector.size() - 1);
    }

}
