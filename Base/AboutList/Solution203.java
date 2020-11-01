package com.company.Base.AboutList;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution203 {
    /**
     * 自己完成：
     *      主要是当删除结点为头节点时有点麻烦，故新建一个头节点
     * 参考官方中描述：
     *      可以通过哨兵节点去解决它，哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等，它们是纯功能的，通常
     *  不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode res=new ListNode(0);
        res.next=head;
        head=res;
        while (head.next!=null){
            if(head.next.val==val)
                head.next=head.next.next;
            else {
                head=head.next;
            }
        }
        return res.next;
    }
}

