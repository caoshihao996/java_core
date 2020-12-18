package staticExample;

public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);
    }

}

//饿汉式
class Bank{

    //1.私有化构造器
    private Bank(){

    }

    //2.内部创建类的对象,此对象必须声明为静态的
    private static Bank instance = new Bank();

    //3.提供公共方法返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}