package staticExample;


//静态方法和属性应该从生命周期的角度去理解
public class StaticExample {
    public static void main(String[] args) {
        Chinese li = new Chinese();
        li.nation = "CHN";
        System.out.println(li.nation);

        Chinese liu = new Chinese();
        liu.nation = "中国";
        System.out.println(liu.nation);

        System.out.println(li.nation);

        Chinese.nation = "CHINA";
        System.out.println(li.nation);

        Chinese.show();
        li.show();
        li.eat();

    }
}


class Chinese {
    String name;
    int age;
    static String nation;

    public static void show(){
        System.out.println("中国人");
        walk();
//        eat();
    }

    public static void walk(){
        System.out.println("走路");
    }

    public void eat(){
        System.out.println("吃饺子");
        walk();
    }
}