package StackQueueHeap;

/*
    给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
    则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        if(k>input.length || k<=0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int num : input){
            queue.add(num);
            if(queue.size()>k){
                queue.poll();
            }

        }
        return new ArrayList<>(queue);
    }
}
