package ThreadExample;

class MyThread1 extends Thread{

    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (MyThread1.class){
                if(ticket>0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        t1.start();
        t2.start();
    }
}
