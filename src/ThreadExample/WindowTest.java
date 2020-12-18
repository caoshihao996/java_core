package ThreadExample;


class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
public class WindowTest {

    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        t1.start();
        t2.start();
    }
}
