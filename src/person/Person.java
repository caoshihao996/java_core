package person;
public class Person {

    private String name;
    private String address;

    public Person(){

    }

    public Person(String initalName, String initalAddress){
        name = initalName;
        address = initalAddress;
    }

    /**
     * 返回人的名字
     * @return 人的名字
     */
    public String getName(){
        return name;
    }

    /**
     * 返回人的住址
     * @return 人的住址
     */
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "name: "+ name +"_address: "+address;
    }
}
