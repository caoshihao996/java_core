package BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    记录下每一层的节点数
 */
public class JZ60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-->0){
                TreeNode cur = queue.poll();
                if(cur==null){
                    continue;
                }
                list.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
                cnt--;
            }
            if(list.size()!=0)
                ret.add(list);
        }
        return ret;
    }
}
