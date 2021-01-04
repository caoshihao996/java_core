package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 实现二叉树的按层遍历
 * 1）其实就是宽度优先遍历，用队列
 * 2）可以通过设置flag变量的方式，来发现某一层的结束
 */
public class TreeLayerOrder {

    public static class Node1{
        int value;
        Node1 left;
        Node1 right;

        public Node1(int v){
            value = v;
        }
    }

    public static void level(Node1 head){
        if(head==null){
            return;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node1 cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(Node1 root){
        if(root==null){
            return null;
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1;//用来保存每一层节点的个数
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int temp = 0;
            while(sum>0){
                Node1 node = queue.poll();
                list.add(node.value);
                if(node.left!=null){
                    queue.add(node.left);
                    temp++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    temp++;
                }
                sum--;
            }
            sum = temp;
            ans.add(list);
        }
        return ans;
    }

    //之字行打印二叉树
    public List<List<Integer>> levelOrder1(Node1 root){
        if(root==null){
            return null;
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1;//用来保存每一层节点的个数
        int num = 1;
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int temp = 0;
            while(sum>0){
                Node1 node = queue.poll();
                list.add(node.value);
                if(node.left!=null){
                    queue.add(node.left);
                    temp++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    temp++;
                }
                sum--;
            }
            sum = temp;
            if(num%2==0){
                for(int i=0,j=list.size()-1;i<j;i++,j--){
                    int res = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, res);
                }
            }
            num++;
            ans.add(list);
        }
        return ans;
    }

    public static int maxWithUseMap(Node1 head){
        if(head == null){
            return 0;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.add(head);
        // key 在哪一层，value
        HashMap<Node1, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;//当前正在统计哪一层的宽度
        int curLevelNodes = 0;//当前层curlevel层，宽度目前是多少
        int max = 0;
        while(!queue.isEmpty()){
            Node1 cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(cur.left != null){
                levelMap.put(cur.left, curNodeLevel+1);
                queue.add(cur.left);
            }
            if(cur.right != null){
                levelMap.put(cur.right, curNodeLevel+1);
                queue.add(cur.right);
            }

            //如果当节点层与当前层相同，则节点数增加，否则对上一层进行结算
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            }else{
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(Node1 head){
        if(head == null){
            return 0;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.add(head);
        Node1 curEnd = head; //当前层，最右节点是谁
        Node1 nextEnd = null; //下一层，最右节点是谁

        int max = 0;
        int curLevelNodes = 0; //当前层的节点数
        while(!queue.isEmpty()){
            Node1 cur = queue.poll();
            if(cur.left!=null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if(cur == curEnd){
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
