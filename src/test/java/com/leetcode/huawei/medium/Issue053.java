package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Issue053 {

    @Test
    public void testFun() {
    }

    Map<Integer, Integer> memory = new HashMap<>();
    public int numTrees(int n) {
        return helper(1, n);
    }
    public int helper(int begin, int end) {
        //因为二叉搜索树的种类只与节点个数有关，那么建立备忘录，防止重复计算
        if (memory.containsKey(end - begin))
            return memory.get(end - begin);
        //空二叉树也是一棵搜索二叉树
        if (begin > end)
            return 1;
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            //以i为根节点时左，右子树的个数
            int leftSize = helper(begin, i - 1);
            int rightSize = helper(i + 1, end);
            sum += leftSize * rightSize;
        }
        memory.put(end - begin, sum);
        return sum;
    }

}
