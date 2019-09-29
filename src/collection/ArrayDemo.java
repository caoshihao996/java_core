package collection;


class ArrayUtil{

    public static void sort(int[] data){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length-i-1;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void reverseOrder(int[] data) {
        int head = 0;
        int tail = data.length - 1;
        int center = data.length / 2;
        for (int i = 0; i < center; i++) {
            int temp = data[head];
            data[head] = data[tail];
            data[tail] = temp;
            head++;
            tail--;
        }
    }

    public static int sum(int ...data){ //可变参数，等同于数组
        int sum = 0;
        for(int temp:data){
            sum+=temp;
        }
        return sum;
    }
}

class Person{
    private String name;
    private int age;
    private Car car = null;
    private Person child[];

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person[] getChild() {
        return child;
    }

    public void setChild(Person[] child) {
        this.child = child;
    }

    public String getInfo(){
        return "名字："+name+" 年龄："+age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}

class Car{
    private String name;
    private double prices;
    private Person person = null;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public Car(String name, double prices){
        this.name = name;
        this.prices = prices;
    }

    public String getInfo(){
        return "车名："+name+" 价格："+prices;
    }

}


public class ArrayDemo {

    public static void main(String[] args){
        //Person[] per = new Person[]{new Person("张三",40), new Person("李四",41)};

        Person person = new Person("里斯",40);
        person.setChild(new Person[]{new Person("吴硕",20),new Person("赵括", 21)});
        Car car = new Car("奔驰",800000.00);
        person.setCar(car);
        car.setPerson(person);
        System.out.println(person.getCar().getInfo());
        System.out.println(car.getPerson().getInfo());
        for(int i=0;i<person.getChild().length;i++){
            System.out.println(person.getChild()[i].getInfo());
        }
    }
}
