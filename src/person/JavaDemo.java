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

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Person1)){
            return false;
        }
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        Person1 per = (Person1)obj;
        return this.name.equals(per.name) && this.age == per.age;
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
        Person1 per1 = new Person1("java",50);
        Person1 per2 = new Person1("java",50);
        System.out.println(per1.equals(per2));
    }
}
