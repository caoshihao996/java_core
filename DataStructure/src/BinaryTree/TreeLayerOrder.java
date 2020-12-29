package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
