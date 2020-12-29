package ClassicProblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKTimes {

    //给定一个由字符串组成的数组String[] strs，给定一个正整数K，返回词频最大的前K个字符串，假设结果是唯一的

    public static class Node{
        public String str;
        public int times;

        public Node(String s, int t){
            str = s;
            times = t;
        }
    }

    public static class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.times - o2.times;
        }
    }

    public static void printTopKAndRank(String[] arr, int topK){
        if(arr == null || arr.length == 0 || topK<1){
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : arr){
            if(!map.containsKey(str)){
                map.put(str, 0);
            }
            map.put(str, map.get(str)+1);
        }
        topK = Math.min(arr.length, topK);
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            Node cur = new Node(entry.getKey(), entry.getValue());
            if(heap.size()<topK){
                heap.add(cur);
            }else{
                if(heap.peek().times<cur.times){
                    heap.poll();
                    heap.add(cur);
                }
            }
        }
        while(!heap.isEmpty()){
            System.out.println(heap.poll().str);
        }
    }

}
