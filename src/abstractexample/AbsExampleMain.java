package abstractexample;

abstract class Animal{
    public abstract void eat();
    public abstract void sleep();
}

class Rabbit extends Animal{
    @Override
    public void eat() {
        System.out.println("chifan");
    }
    public void sleep(){
        System.out.println("shuijiao");
    }
}
public class AbsExampleMain {
    public static void main(String[] args){
        Rabbit rabbit = new Rabbit();
        rabbit.eat();
    }
}
