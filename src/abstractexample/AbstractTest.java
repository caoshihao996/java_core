package abstractexample;

/*
    abstract可以用来修饰类和方法

    abstract修饰类：抽象类
    此类不能实例化
    抽象类中一定有构造器，便于子类实例化时调用
    开发中都会提供抽象类的子类

    abstract修饰方法：抽象方法
    只有方法的声明，没有方法体
    包含抽象方法的类一定是抽象类，反之，抽象类不一定有抽象方法
    子类必须重写父类（包括间接父类）中的所有抽象方法,否则子类也应该声明为抽象类
 */

public class AbstractTest {

    public static void main(String[] args) {

        //一旦Person抽象了，就不能实例化
//        Person p1 = new Person();
//        p1.eat();
        Student student = new Student("tom",13);
        student.walk();
    }
}


abstract class Person{
    String name;
    int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("chifan");
    }

    public abstract void walk();
}

class Student extends Person{

    public Student(String name, int age){
        super(name,age);
    }

    public void walk(){
        System.out.println("学生吃营养餐");
    }
}