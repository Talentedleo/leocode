package com.leetcode.huawei.medium;

import com.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * 面试题 04.05. 合法二叉搜索树
 *
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 */
public class Issue170 {

    @Test
    public void testFun() {

    }

    /*
  二叉搜索树中序遍历是有序的。
  */
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean l = isValidBST(root.left);
        if( ! l){
            return false;
        }
        if(pre == null){
            pre = root;
        }else{
            if(pre.val >= root.val){
                return false;
            }
            pre = root;
        }
        return isValidBST(root.right);
    }

}
