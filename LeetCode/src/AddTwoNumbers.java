


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1!=null || l2!=null){
            int temp = (l1 == null ?  0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = temp / 10;
            temp = temp % 10;
            cur.next = new ListNode(temp);
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            cur = cur.next;
            if(carry == 1){
                cur.next = new ListNode(carry);
            }
        }
        return head.next;
    }
}
