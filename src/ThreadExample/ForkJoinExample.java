package ThreadExample;

import java.util.concurrent.*;

public class ForkJoinExample extends RecursiveTask<Integer> {
    private final int threshold = 5;
    private int first;
    private int last;

    public ForkJoinExample(int first,int last){
        this.first=first;
        this.last=last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if(last - first <= threshold){
            for (int i = first; i < last; i++) {
                result += i;
            }
        }else {
            int middle = first + (last- first)/2;
            ForkJoinExample leftTask = new ForkJoinExample(first,middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle+1, last);
            leftTask.fork();
            rightTask.fork();
            result = (Integer) leftTask.join() + (Integer) rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample example = new ForkJoinExample(1,10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(example);
        System.out.println(result.get());
    }
}
