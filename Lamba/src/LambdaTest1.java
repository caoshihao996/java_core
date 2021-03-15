import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 1.举例：(o1,o2)->Integer.compare(o1,o2)
 * 2.格式：
 *      ->:lambda操作符
 *      ->左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *      ->右边：lambda体（重写抽象方法的方法体）
 *
 * 3.Lambda的使用6中情况
 *
 * 4.Lambda表达式的本质：作为函数式接口的实例
 *
 * 5.如果一个接口中，只声明了一个抽象方法，则称此接口为函数式接口
 */

public class LambdaTest1 {

    //语法一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();
        System.out.println("******************");

        Runnable r2 = ()-> System.out.println("我爱北京故宫");
        r2.run();
    }

    //语法二：Lambda需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言");

        System.out.println("____________________");

        Consumer<String> con1 = (String s)->{ System.out.println(s); };
        con1.accept("一个听的人当真，一个说的人当真");
    }

    //语法三：数据类型可以省略，因为可由编译器推断得出，称为”类型推断“
    @Test
    public void test3(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言");

        System.out.println("____________________");

        Consumer<String> con2 = (s)->{
            System.out.println(s);
        };
        con2.accept("一个听的人当真，一个说的人当真");
    }

    //语法四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con2 = (s)->{
            System.out.println(s);
        };
        con2.accept("一个听的人当真，一个说的人当真");
        System.out.println("____________________");

        Consumer<String> con3 = s->{
            System.out.println(s);
        };
        con3.accept("一个听的人当真，一个说的人当真");

    }

    //语法五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,21));
        System.out.println("____________________");
        Comparator<Integer> com2 = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,6));
    }

    //语法六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com2 = (o1,o2)->{
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,6));
        System.out.println("____________________");

        Comparator<Integer> com = (o1,o2)->o1.compareTo(o2);
        System.out.println(com.compare(12,21));
    }
}
