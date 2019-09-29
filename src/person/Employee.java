package person;

public class Employee extends Person {

    private double salary;

    public Employee(String initalName, String initalAddress, double initalSalary) {
        super(initalName, initalAddress);
        salary = initalSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        /**return "name: "+ getName() +" _address: "+getAddress()+ " _salary:"+salary;*/
        return super.toString()+"  salary: "+salary;
    }
}
