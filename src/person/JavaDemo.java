package person;


import java.security.PublicKey;

class Person1{
    private String name;
    private int age;

    public Person1(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person1(){
        System.out.println("创建一个person对象");
    }

    @Override
    public String toString() {
        return this.name+" "+this.age;
    }
}


class Student extends Person1{
    private String school;
    public Student(){
        super();
        System.out.println("创建一个student对象");
    }
    public Student(String name, int age, String school){
        super(name, age);
        this.school = school;
    }

    public Student(String name, int age){
        //this(name,age,"jalidui");
    }

    @Override
    public String toString() {
        return super.toString()+" "+ this.school;
    }
}

public class JavaDemo {
    public static void main(String args[]){
        Student student = new Student("jack", 45, "jialidui");
        System.out.println(student.toString());
    }
}
