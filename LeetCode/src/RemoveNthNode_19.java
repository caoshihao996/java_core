import org.junit.Test;

import java.awt.*;

public class RemoveNthNode_19 {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

//        if(head==null){
//            return null;
//        }
//        ListNode cur = head;
//        int length= 0;
//        while(cur!=null){
//            cur = cur.next;
//            length++;
//        }
//        if(n==length){
//            return head.next;
//        }
//        int curP = 1;
//        cur = head;
//        while(cur!=null){
//            if(length-n == curP && cur.next != null){
//                cur.next = cur.next.next;
//            }
//            cur = cur.next;
//            curP++;
//        }
//        System.out.println(length);
//        return head;
        ListNode temp = new ListNode(0, head);
        ListNode first = head;
        ListNode second = temp;
        for(int i=0;i<n;i++){
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return temp.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2; i<=5; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        head = removeNthFromEnd(head, 1);

        cur = head;
        while(cur!=null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
