package LinkedList;

/*
    输入一个链表，输出该链表中倒数第k个结点。
 */
public class JZ14 {

    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode pHead, int k){
        ListNode bfe = pHead;
        ListNode aft = pHead;
        while (bfe!=null && k-- > 0){
            bfe = bfe.next;
        }
        if(k>0){
            return null;
        }
        while (bfe!=null){
            bfe = bfe.next;
            aft = aft.next;
        }
        return aft;
    }
}
