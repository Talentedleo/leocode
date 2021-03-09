package com.leetcode.huawei.medium;

import com.leetcode.common.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 */
public class Issue015 {

    @Test
    public void testFun() {
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        Map<Integer,ListNode> m = new HashMap<Integer,ListNode>();
        int index=1;
        while(temp!=null){
            m.put(index++,temp);
            temp = temp.next;
        }
        int size = m.size();
        if(size == 1)
            return null;
        if(n == 1){
            m.get(size-1).next = null;
        }else if(n == size){
            head = head.next;
        }else{
            m.get(size-n).next = m.get(size-n+2);
        }
        return head;
    }
}
