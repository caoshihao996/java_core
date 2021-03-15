package LinkedList;

/*
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
    请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class JZ25 {

    class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label){
            this.label = label;
        }
    }

    /*
        第一步：在每个节点的后面插入复制节点。
        第二步：对复制节点的random链接进行赋值。
        第三步：拆分。
     */
    public RandomListNode Clone(RandomListNode pHead){

         if(pHead==null)
             return null;
         RandomListNode cur = pHead;
         while (cur!=null){
             RandomListNode clone = new RandomListNode(cur.label);
             clone.next = cur.next;
             cur.next = clone;
             cur = clone.next;
         }
         cur = pHead;
         while (cur!=null){
             RandomListNode clone = cur.next;
             if(cur.random!=null){
                 clone.random = cur.random.next;
             }
             cur = clone.next;
         }
         cur = pHead;
         RandomListNode pClonedHead = pHead.next;
         while(cur.next!=null){
             RandomListNode next = cur.next;
             cur.next = next.next;
             cur = next;
         }
         return pClonedHead;

    }
}
