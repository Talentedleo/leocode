package com.leetcode.huawei.medium;

import com.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 */
public class Issue101 {

    @Test
    public void testFun() {
    }

    public int countNodes(TreeNode root) {
        return getCount(root, 1);
    }

    private int getCount(TreeNode root, int index) {
        // 树为空时，返回0.
        if (root == null) {
            return 0;
        }
        // 判断是否为叶节点，完全二叉树只需看left.
        if (root.left == null) {
            return index;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 左子树高度 > 右子树高度时，最右下节点在左子树；相等时在右子树
        if (leftDepth > rightDepth) {
            return getCount(root.left, 2 * index);
        }
        return getCount(root.right, 2 * index + 1);
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

}
