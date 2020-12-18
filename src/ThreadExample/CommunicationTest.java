package ThreadExample;

/*
    线程通信的例子：使用两个线程交替打印数字

    涉及到的三个方法：
    wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
    notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，唤醒优先级较高的
    notifyAll():一旦执行此方法，就会唤醒所有被wait的线程

    说明
    1.wait(),notify(),notifyAll()必须使用在同步代码块或者同步方法
    2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。否则会出现异常
    3.wait(),notify(),notifyAll()三个方法定义在Object中

    面试题：sleep和wait方法的异同
    1.相同点：都可以使当前线程进入阻塞转台
    2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep()，Object中声明wait()
               2)调用的要求不同，sleep()可以在任何地方调用，wait()只能在同步代码块或者同步方法中使用
               3)关于是否释放同步监视器的问题：如果两个方法都使用在同步代码块或者同步方法中，sleep()不会释放，wait()会释放
 */
class Number implements Runnable{

    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){

                obj.notify();//对象要与同步监视器相同

                if(number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
