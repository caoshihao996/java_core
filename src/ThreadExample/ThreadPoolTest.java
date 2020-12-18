package ThreadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    创建线程的方式四：使用线程池
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPoolTest {

    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());
        //2.执行指定的线程操作。需要提供实现Runnable接口或者Callable接口实现类的对象
        service.execute(new NumberThread());
        service.execute(new NumberThread1());

        //3.关闭连接池
        service.shutdown();
    }
}
