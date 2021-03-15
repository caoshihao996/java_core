package BinaryTree;

public class BST2LinkedList {

    private TreeNode pre;
    private TreeNode head;

    public TreeNode Convert(TreeNode root){

        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node){
        if(node==null)
            return;
        inOrder(node.left);
        node.left=pre;
        if(pre!=null)
            pre.right=node;
        pre=node;
        if(head==null)
            head=node;
        inOrder(node.right);
    }
}
