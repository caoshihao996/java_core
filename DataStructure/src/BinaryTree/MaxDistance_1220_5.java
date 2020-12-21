package BinaryTree;

public class MaxDistance_1220_5 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    public static class Info{
        public int maxDistance;
        public int height;

        public Info(int dis, int h){
            maxDistance = dis;
            height = h;
        }
    }

    public static Info process(Node X){
        if(X == null){
            return new Info(0, 0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(
                Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
                leftInfo.height + rightInfo.height + 1);
        return new Info(maxDistance, height);
    }
    public static int maxDistance2(Node head){
        return process(head).maxDistance;
    }
}
