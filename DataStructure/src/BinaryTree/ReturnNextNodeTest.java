package BinaryTree;

public class ReturnNextNodeTest {

    static class Node{
        int value;
        Node left;
        Node right;
        Node parent;
        Node(int v){
            value = v;
        }
    }

    //在中序遍历中
    public static Node getSuccessorNode(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            return getLeftMost(node.right);
        }else{//无右子树
            Node parent = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
