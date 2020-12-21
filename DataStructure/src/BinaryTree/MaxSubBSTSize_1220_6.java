package BinaryTree;
public class MaxSubBSTSize_1220_6 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static class Info{
        public boolean isAllBST;
        public int maxSubBSTSize;
        public int min;
        public int max;
        public Info(boolean is, int size, int mi, int ma){
            isAllBST = is;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

    public static Info process(Node X){
        if(X == null){
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        boolean isAllBST = false;
        int maxSubBSTSize = 0;
        int min = X.value;
        int max = X.value;
        if(leftInfo!=null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if(rightInfo!=null){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        if(leftInfo!=null){
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if(rightInfo!=null){
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        if((leftInfo == null ? true : leftInfo.isAllBST) &&
                (rightInfo == null ? true : rightInfo.isAllBST) &&
                (leftInfo == null ? true : leftInfo.max < X.value) &&
                (rightInfo == null ? true : rightInfo.max < X.value)){
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
            isAllBST = true;
        }

        return new Info(isAllBST, maxSubBSTSize, min, max);
    }

    public static int getBSTSize(Node head){
        return 0;
    }
}
