package ThreadExample;


/*
    创建多线程的方式二：实现Runnable接口
       1.创建一个类实现Runnable接口的类
       2.实现类区实现Runnable中的抽象方法：run()
       3.创建实现类的对象
       4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
       5.通过Thread类的对象调用start()
 */

class MThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

class Windows1 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();//多个线程必须共用同一个

    @Override
    public void run() {
        while(true){

            synchronized (obj){//可用this代替
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

public class ThreadTest2 {


    public static void main(String[] args) {
//        MThread mThread = new MThread();
//        Thread t2 = new Thread(mThread);
//        t2.start();
        Windows1 windows1 = new Windows1();
        Thread t1 = new Thread(windows1);
        Thread t2 = new Thread(windows1);
        Thread t3 = new Thread(windows1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }


}
