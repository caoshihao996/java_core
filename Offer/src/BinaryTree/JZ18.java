package BinaryTree;

/*
    操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class JZ18 {

    public TreeNode Mirror(TreeNode pRoot){
        if (pRoot==null)
            return null;
        swap(pRoot);
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    private void swap(TreeNode root){
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
