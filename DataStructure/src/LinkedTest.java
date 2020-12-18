/**
 * 两个可能有环的链表的交点
 */

class Node{
    int value;
    Node next;
    Node(int v){
        value = v;
    }
}

public class LinkedTest {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node5;

        Node crossNode = getLoopNode(head);
        System.out.println(crossNode.value);
    }

    public static Node getIntersection(Node head1, Node head2){
        if(head1 == null || head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1==null && loop2==null){
            return noLoop(head1, head2);
        }
        if(loop1!=null && loop2!=null){
            return  bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    //返回一个链表第一个入环的节点
    public static Node getLoopNode(Node head){
        if(head ==null || head.next ==null || head.next.next == null){
            return null;
        }
        // n1 慢 n2 快
        Node n1 = head.next; //n1->slow
        Node n2 = head.next.next; //n2->fast
        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;  //n2->walk again from head
        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    //如果两个无环链表相交返回第一个相交的节点，如果不相交返回空
    public static Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while(cur1.next != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        //n : 链表1的长度减去链表2的长度
        cur1 = n > 0 ? head1 : head2; //长的变为cur1
        cur2 = cur1 == head1 ? head2 : head1; //短的头节点为cur2
        n = Math.abs(n);
        while(n!=0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个链表都有环，返回第一个相交的节点，不相交则返回空
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1!=loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2!=loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 :head1;
            n = Math.abs(n);
            while(n!=0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1!=cur2){
                cur1= cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1!=loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
