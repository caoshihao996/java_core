package BinaryTree;

/*
    请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class JZ58 {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null)
            return true;
        return process(pRoot.left, pRoot.right);
    }

    boolean process(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);

    }
}
