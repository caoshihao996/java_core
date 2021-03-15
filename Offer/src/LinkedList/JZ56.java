package LinkedList;


/*
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class JZ56 {

    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode head = new ListNode(Integer.MAX_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur!=null){
            if(cur.next!=null && cur.next.val==cur.val){
                while (cur.next!=null && cur.next.val==cur.val){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
