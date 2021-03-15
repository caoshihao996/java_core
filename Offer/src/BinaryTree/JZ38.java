package BinaryTree;


/*
    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class JZ38 {

    public int TreeDepth(TreeNode root){
        if(root==null)
            return 0;
        return process(root);
    }

    private int process(TreeNode root) {
        if(root==null)
            return 0;
        int leftD = process(root.left);
        int rightD = process(root.right);
        int maxD = Math.max(leftD, rightD) + 1;
        return maxD;
    }
}
