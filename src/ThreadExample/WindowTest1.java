package ThreadExample;

class Window1 extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private static synchronized void show(){//同步监视器：当前类
        if(ticket>0){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
            ticket--;
        }

    }
}
public class WindowTest1 {

    public static void main(String[] args) {
        Window1 t1 = new Window1();
        Window1 t2 = new Window1();
        t1.start();
        t2.start();
    }
}
