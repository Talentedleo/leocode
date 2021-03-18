package com.leetcode.huawei.medium;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Issue075 {

    @Test
    public void testFun() {
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        TreeNode p = root,r = null;
        List<Integer>ans = new ArrayList();
        Deque<TreeNode> s = new ArrayDeque();
        while(!s.isEmpty() || p != null)
        {
            if(p != null)
            {
                s.push(p);
                p = p.left;
            }
            else
            {
                p = s.peek();
                if(p.right == null || p.right == r)
                {
                    ans.add(p.val);
                    r = p;
                    s.pop();
                    p = null;
                }
                else
                    p = p.right;

            }

        }

        return ans;
    }

}
