package BinaryTree;

public class LowestAncestorNode {


    /*
        在二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return root;
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowest(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q)
            return root;
        TreeNode left = lowest(root.left, p, q);
        TreeNode right = lowest(root.right, p, q);
        return left==null?right : right==null?left : root;
    }
}
