package ThreadExample;


import java.util.concurrent.locks.ReentrantLock;

class Accout{
    private double balance;

    public Accout(double balance) {
        this.balance = balance;
    }

//    public synchronized void deposit(double amt){
    public void deposit(double amt){
        if(amt>0){
            balance+=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
        }
    }
}

class Customer extends Thread{
    private Accout accout;
    private static ReentrantLock lock = new ReentrantLock(true);

    public Customer(Accout accout){
        this.accout = accout;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try{
                lock.lock();
                accout.deposit(1000);
            }finally {
                lock.unlock();
            }
        }
    }
}

public class AccountTest {

    public static void main(String[] args) {
        Accout acct = new Accout(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
