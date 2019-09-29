package person;

public class Main {
    public static void main(String[] args){
        Person person1 = new Person("Add", "XiAn");
        Employee employee = new Employee("Bdd", "changan", 10000);
        System.out.println(person1.toString());
        System.out.println(employee.toString());

        Person person2 = employee;
        System.out.println(person2.toString());
        /**System.out.println(person2.geSalary());*/
        double salary = ((Employee)person2).getSalary();
        System.out.println(salary);
        /*double salary1 = ((Employee)person1).getSalary();*/

        Person person = new Employee("joe smith","100 mainm ave", 10000);
        /*double salary1 = ((Employee)person).getSalary();
        System.out.println(salary1);*/
        if(person instanceof Employee){
            salary = ((Employee)person).getSalary();
        }

        int ages[] = new int[5];
        for(int i=0;i<ages.length;i++){
            int x = ages[i];
            System.out.println(x);
        }
    }
}
