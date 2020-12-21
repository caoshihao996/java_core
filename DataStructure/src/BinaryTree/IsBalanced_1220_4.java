package BinaryTree;

public class IsBalanced_1220_4 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean b, int h){
            isBalanced = b;
            height = h;
        }
    }

    //左、右要求一样，Info信息返回的结构体
    public static Info process2(Node X){
        if(X == null){
            return new Info(true, 0);
        }
        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);

        int height = Math.max(leftInfo.height, rightInfo.height) +1;
        boolean isBalanced = true;

        if(!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height)>1){
            isBalanced = false;
        }

        return new Info(isBalanced, height);
    }

    public static boolean isBalanced2(Node head){
        return process2(head).isBalanced;
    }
}
