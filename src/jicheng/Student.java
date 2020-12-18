package jicheng;

public class Student extends Person {

    String major;

    public Student(){

    }

    public Student(int age, String name, String major){
        super(age, name);
        this.major = major;
    }
}
