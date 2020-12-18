import org.junit.Test;

import java.util.Date;

public class DataTimeTest {

    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }


    /*
    java.util.Date类
        |--java.sql.Date类

       1.两个构造器的使用
       2.两个方法的使用
        >toString():显示当前的年月日时分秒
        >getTime():获取当前Date对象对应的毫秒数

       3.java.sql.Date类对应数据库中的日期类型变量
       >如何实例化
       >如何将一个java.util.Date转换为一个java.sql.Date

     */

    @Test
    public void test2(){
        //构造器一Date():创建一个当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1604408857907L);
        System.out.println(date2);

        //创建java.sql.Date
        java.sql.Date date3 = new java.sql.Date(3553234252L);
        System.out.println(date3.toString());

        //如何将一个java.util.Date转换为一个java.sql.Date
        //情况一：
        Date date4 = new java.sql.Date(4323424234L);
        java.sql.Date date5 = (java.sql.Date)date4;
        System.out.println(date5.toString());

        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
}
