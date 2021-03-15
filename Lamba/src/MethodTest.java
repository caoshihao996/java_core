import org.junit.Test;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1.使用情境：当需要传递给Lambda体的操作，已经有视线的方法了，可以使用方法引用。
 *
 * 2.方法引用，本质上就是Lambda表达式，二Lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例。
 *
 * 3.使用格式：  类（对象）:: 方法名
 *
 * 4.具体分为如下三种情况：
     * 对象::非静态方法
     * 类::静态方法
     * 类::非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 *   形参列表和返回值类型相同！(针对情况1和2)
 */
public class MethodTest {


    //情况一：对象：：实例方法
    @Test
    public void test1(){
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("北京");
        System.out.println("-------------------------");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");
    }

    @Test
    public void test2(){
//        Supplier<String> sup1 = ()->
    }

    //情况二：类::静态方法
    @Test
    public void test3(){
        Comparator<Integer> com1 = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(12,15));
        System.out.println("----------------------");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(23,16));
    }

    //情况三：类::实例方法
    //Comparator中的int compare(T t1, T t2)
    //String中的int t1.compareTo(t2)
    @Test
    public void test4(){
        Comparator<String> com1 = (s1,s2)->s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));
        System.out.println("-------------------------");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd","abm"));
    }
}
