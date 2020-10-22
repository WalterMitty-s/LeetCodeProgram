package com.company.Base.Sort;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {

     int val;

     ListNode next;

     ListNode(int x) { val = x; }

 }
public class Solution147 {
    /**
     * 非官方解法：
     * 自己没做出来，
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode result=new ListNode(0);
        result.next=head;
        ListNode now=head.next;

        while (now!=null){
            if(head.val<now.val){
                head=now;
                now=now.next;
            }
            else {
                ListNode node=result;
                //寻找一个节点node的node.next应为插入的节点
                while (node.next!=now&&node.next.val<now.val){
                    node=node.next;
                }

                head.next=now.next;
                now.next=node.next;
                node.next=now;
                now=head.next;
            }
        }

        return result.next;
    }
}
