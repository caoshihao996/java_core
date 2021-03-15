package BinaryTree;

import org.junit.Test;

import java.util.*;

/*
    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
    第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class JZ59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-->0){
                TreeNode cur = queue.poll();
                if(cur==null)
                    continue;
                list.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            if (reverse)
                Collections.reverse(list);
            reverse=!reverse;
            if (list.size()!=0)
                ret.add(list);
        }
        return ret;
    }

    @Test
    public void test(){
        int cnt = 10;
        while(cnt-->0){
            System.out.print(cnt+" ");
        }
    }
}
