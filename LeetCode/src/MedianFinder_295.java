import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder_295 {

    int count;
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder_295(){
        count = 0;
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 02-01;
            }
        });
        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num){
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(count %2 != 0){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian(){
        if(count %2 !=0){
            return (double)maxHeap.peek();
        }else{
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        }
    }
}
