package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;

public class LowestAncestor_12_30 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            value = data;
        }
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2){
        if(head == null){
            return null;
        }

        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
        HashSet<Node> o1Set = new HashSet<>();
        Node cur = o1;
        o1Set.add(cur);
        while(parentMap.get(cur)!=null){
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while(!o1Set.contains(cur)){
            cur = parentMap.get(cur);
        }
        return cur;
    }

    private static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
        if(head.left!=null){
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if(head.right!=null){
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }


    public static class Info{
        public Node ans;
        public boolean findo1;
        public boolean findo2;

        public Info(Node a, boolean f1, boolean f2){
            ans = a;
            findo1 = f1;
            findo2 = f2;
        }
    }

    public static Info process(Node head, Node o1, Node o2){
        if(head == null){
            return new Info(null, false, false);
        }

        Info leftInfo = process(head.left, o1, o2);
        Info rightInfo = process(head.right, o1, o2);

        boolean findo1 = head == o1 || leftInfo.findo1 || rightInfo.findo1;
        boolean findo2 = head == o2 || leftInfo.findo2 || rightInfo.findo2;

        //o1和o2最初的交汇点在哪
        Node ans = null;
        //左树提前交汇
        if (leftInfo != null){
            ans = leftInfo.ans;
        }
        //右树提前交汇
        if(rightInfo != null){
            ans = rightInfo.ans;
        }
        //在当前节点交汇
        if(ans == null){
            if(findo1 && findo2){
                ans = head;
            }
        }
        return new Info(ans, findo1, findo2);
    }
}
