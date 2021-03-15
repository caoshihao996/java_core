package LinkedList;


import java.util.ArrayList;
import java.util.Stack;

/*
    输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class JZ3 {
    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }


    //栈方法
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//        ListNode node = listNode;
//        while (node!=null){
//            stack.push(node.val);
//            node = node.next;
//        }
//        while (!stack.isEmpty()){
//            ret.add(stack.pop());
//        }
//        return ret;
//    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        ListNode temp = null;
        ListNode curNode = listNode;
        ListNode preNode = null;
        while (curNode!=null){
            temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }

        while (preNode!=null){
            ret.add(preNode.val);
            preNode = preNode.next;
        }
        return ret;
    }
}
