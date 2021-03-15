import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;

        /*
        newInstance():调用此方法,创建对应的运行时类的对象，内部调用了运行时类的空参构造器

        想要调用此方法，要求：
        1运行时类必须提供空参的构造器
        2空参构造器的权限要求够，通常为public
         */
        Person o = clazz.newInstance();
        System.out.println(o);
    }

    @Test
    public void test2(){
        int num = new Random().nextInt(3);//0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
