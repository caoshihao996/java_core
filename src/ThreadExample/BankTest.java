package ThreadExample;

public class BankTest {
}


//将懒汉式改为线程安全的
class Bank{

    private Bank(){}
    private static Bank instance = null;
    public static Bank getInstance(){
//        synchronized (Bank.class){
//            if(instance == null){
//                instance = new Bank();
//            }
//        }
//        return instance;

        if(instance==null){
            synchronized (Bank.class){
                if(instance==null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
