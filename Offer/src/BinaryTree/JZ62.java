package BinaryTree;

import java.util.ArrayList;

/*
    给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 */
public class JZ62 {

    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot==null || k<=0)
            return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        process(pRoot,list);
        if(k>list.size())
            return null;
        return list.get(k-1);
    }

    private void process(TreeNode node, ArrayList<TreeNode> list){
        if(node==null)
            return;
        process(node.left, list);
        list.add(node);
        process(node.right, list);
    }
}
