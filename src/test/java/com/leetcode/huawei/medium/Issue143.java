package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Collections;
import java.util.Stack;

/**
 * 385. 迷你语法分析器
 *
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 提示：你可以假定这些字符串都是格式良好的：
 *
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9、[、-、,、]
 *  
 *
 * 示例 1：
 *
 * 给定 s = "324",
 *
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * 示例 2：
 *
 * 给定 s = "[123,[456,[789]]]",
 *
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 *
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 *     i.  一个 integer 包含值 456
 *     ii. 一个包含一个元素的嵌套列表
 *          a. 一个 integer 包含值 789
 *
 */
public class Issue143 {

    @Test
    public void testFun() {

    }

//    public NestedInteger deserialize(String s) {
//        String[] items = s.replace(",", " ")
//                .replace("[", "[ ")
//                .replace("]", " ]")
//                .replace("[  ]", "[ ]")
//                .split(" ");
//        Stack<Object> stack = new Stack<>();
//        for (String item : items) {
//            if (item.equals("[")) {
//                stack.push(item);
//            } else if (item.equals("]")) {
//                NestedInteger nestedInteger = new NestedInteger();
//                while (true) {
//                    Object pop = stack.pop();
//                    if (pop.equals("[")) break;
//                    nestedInteger.add((NestedInteger) pop);
//                }
//                // 栈里面拿出来是逆序的，反转一下即可
//                Collections.reverse(nestedInteger.getList());
//                stack.push(nestedInteger);
//            } else {
//                stack.push(new NestedInteger(Integer.parseInt(item)));
//            }
//        }
//        return (NestedInteger) stack.peek();
//    }

}
