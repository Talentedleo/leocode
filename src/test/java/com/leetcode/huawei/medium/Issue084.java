package com.leetcode.huawei.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 */
public class Issue084 {

    @Test
    public void testFun() {
    }

    /**
     * @param nums 一组非负整数
     * @return - String.compareTo() 是按照 lexicographically, 字典顺序排列的
     * - 利用compareTo, 来倒序排列 string, 刚好就得到我们要的结果.
     */
    public String largestNumber(int[] nums) {
        //合法性
        if (nums == null || nums.length == 0) {
            return "";
        }
        //数字数组->字符数组  转化
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        //重写排序规则 12-14ms
        // Arrays.sort(strArr, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         //继承此方法的时候，要自定义比较器，conpareTo方法返回值为1(升序),0，-1(降序)。
        //         //返回正值 交换；负值不交换
        //         return (o2 + o1).compareTo((o1 + o2));
        //     }
        // });
        //Lambda表达式 重写排序规则 速度慢了5倍 72-82ms
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        //字符数组->字符串 转化
        StringBuilder sb = new StringBuilder();
        for (String aStrArr : strArr) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        //特殊情况 若干个零
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }

}
