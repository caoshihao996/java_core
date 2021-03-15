package ThreadExample;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {

    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
            }
        }
    }

    @Test
    public void test(){
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->e1.func1());
        service.execute(()->e2.func1());
    }
}




