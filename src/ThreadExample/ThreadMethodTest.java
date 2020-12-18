package ThreadExample;

class HelloThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
        }
    }

    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {

    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("Thread:1");
//        t1.setName("线程1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
//            if(i==20){
//                try{
//                    t1.join();
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(t1.isAlive());
    }
}
