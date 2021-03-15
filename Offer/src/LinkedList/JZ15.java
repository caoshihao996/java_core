package LinkedList;

/*
    输入一个链表，反转链表后，输出新链表的表头
 */
public class JZ15 {

    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head){

        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
