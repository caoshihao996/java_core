package ThreadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private Lock lock = new ReentrantLock();

    public void func(){
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample lockExample = new ReentrantLockExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->lockExample.func());
        service.execute(()->lockExample.func());
    }
}
