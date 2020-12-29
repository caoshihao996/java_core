package BinaryTree;

import java.util.LinkedList;

//判断一棵树是否为完全二叉树
public class IsCBT_1229_01 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            value = data;
        }
    }

    public static boolean isCBT1(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            //如果遇到了不双全的节点之后，又发现当前节点不是叶节点
            if(
                    (leaf && (l != null || r != null)) || (l == null && r != null)
            ){
                return false;
            }

            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isCBT2(Node head){
        if(head == null){
            return true;
        }
        return process(head).isCBT;
    }

    //对于每一棵子树，是否是满的，是否是完全二叉树，高度
    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean full, boolean cbt, int h){
            isFull = full;
            isCBT = cbt;
            height = h;
        }
    }

    public static Info process(Node head){
        if(head == null){
            return new Info(true, true, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && rightInfo.height == leftInfo.height;
        boolean isCBT = false;

        if(isFull){
            isCBT = true;
        }else{
            if(leftInfo.isCBT && rightInfo.isCBT){
                if(leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height+1){
                    isCBT = true;
                }
                if(leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height+1){
                    isCBT = true;
                }
                if(leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height){
                    isCBT = true;
                }
            }
        }
        return new Info(isFull, isCBT, height);
    }
}
