package BinaryTree;

/*
    输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
    平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
    并且左右两个子树都是一棵平衡二叉树。
 */
public class JZ39 {

    public boolean IsBalanced(TreeNode root){
        if(root==null)
            return true;
        return process(root).isBalanced;
    }

    class Info{
        int height;
        boolean isBalanced;
        public Info(int height, boolean isBalanced){
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }

    public Info process(TreeNode node){
        if(node==null)
            return new Info(0,true);
        Info left = process(node.left);
        Info right = process(node.right);

        int h = Math.max(left.height, right.height)+1;
        boolean isB = false;
        if(left.isBalanced && right.isBalanced && Math.abs(left.height-right.height)>1)
            isB=true;
        return new Info(h, isB);
    }
}
