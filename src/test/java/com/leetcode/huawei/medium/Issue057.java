package com.leetcode.huawei.medium;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Issue057 {

    @Test
    public void testFun() {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode (preorder[0]);
        for(int i=0;i<preorder.length;i++){
            if(preorder[0]==inorder[i]){
                root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }

}
