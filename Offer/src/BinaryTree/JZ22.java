package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
    二叉树的按层遍历
 */
public class JZ22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            ret.add(cur.val);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        return ret;
    }
}
