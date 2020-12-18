package ThreadExample;


/*
   多线程的创建，方式一：继承于Thread类
   1.创建一个继承Thread类的子类
   2.重写Thread类的run()-->将此线程执行的操作声明在run()中
   3.创建Thread类子类的对象
   4.通过此独享调用Thread类中的start()
 */

class MyThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest{

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for(int i=0;i<1000;i++){
            if(i%2==0){
                System.out.println(i+"-----");
            }
        }
    }
}
