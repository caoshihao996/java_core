import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {


    //反射之前
    @Test
    public void test1(){

        Person p1 = new Person("tom",12);
        p1.age=10;
        System.out.println(p1.toString());
        p1.show();

        //在Person类外部，不可以通过Person类对象调用其内部私有结构
    }

    //反射之后，对Person的操作
    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;
        //1.通过反射创建类的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        Person p1 = (Person)tom;
        System.out.println(p1.toString());

        //2.通过反射，调用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p1,10);
        System.out.println(p1.toString());

        //3.调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p1);


        //通过反射，可以调用Person类私用结构。比如，私有的构造器/方法/属性

        //调用私有的构造器
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p2 = (Person)constructor1.newInstance("Jerry");
        System.out.println(p2);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"Hanmeimei");
        System.out.println(p2);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p2,"中国");
        System.out.println(nation);
    }

    /*
     *关于java.lang.Class类的理解
     * 1.类的加载过程
     * 程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾）,接着我们使用
     * java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程称为类的加载。
     * 加载到内存中的类，称为运行时类，此运行时类，就作为Class的一个实例。
     *
     * 2.换句话说，Class的实例就对应着一个运行时类。
     *
     * 3.加载到内存中的运行时类，会缓存一段时间，在此时间内，我们可以通过不同的方式来获取此运行时类。
     */


    //获取Class的实例方式
    @Test
    public void test3() throws ClassNotFoundException {
        //1调用运行时类的属性.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //2通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //3调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        //4使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("Person");
        System.out.println(clazz4);

    }

    @Test
    public void test4() throws Exception {
        Class clazz = Person.class;
        Person  p = (Person) clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"tom");
        System.out.println(p.getName());
    }

    @Test
    public void test5() throws Exception {
        Class clazz = Person.class;
        Person  p = (Person) clazz.newInstance();

        Method show = clazz.getDeclaredMethod("showNation", String.class);
        show.setAccessible(true);
        show.invoke(p, "CHN");
    }

}
