package BinaryTree;


/*
    给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class JZ57 {


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null)
            return null;
        if(pNode.right!=null){
            return getMostLeftNode(pNode.right);
        }else {//没有右子树
            TreeLinkNode parent = pNode.next;
            while(parent!=null && parent.left!=pNode){
                pNode = parent;
                parent = parent.next;
            }
            return parent;
        }
    }

    public TreeLinkNode getMostLeftNode(TreeLinkNode node){
        if(node==null)
            return node;
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
}
