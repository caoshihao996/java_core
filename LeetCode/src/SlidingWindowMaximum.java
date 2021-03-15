import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

//        int n = nums.length;
//        int[] res = new int[n-k+1];
//        for(int i=0; i<=n-k; i++){
//            res[i] = getMax(nums, i, i+k);
//        }
//        return res;
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], 1});
        }
        res[0] = queue.peek()[0];
        for(int i =k; i<n; i++){
            queue.add(new int[]{nums[i],i});
            while(queue.peek()[1]<=i-k){
                queue.poll();
            }
            res[i-k+1] = queue.peek()[0];
        }
        return res;
    }

    public int getMax(int[] nums, int l, int r){
        int max = -10001;
        for (int i = l; i < r; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}


