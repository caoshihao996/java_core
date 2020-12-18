package string_example;

import org.junit.Test;

public class StringBufferBuilderTest {


    /*
    String、StringBuffer、StringBuilder三者以同
    String:不可变的字符序列；底层使用char[]存储；
    StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储；
    StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储;

    源码分析：
    String str = new String();//new char[0]
    String str1 = new String("abc");//new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer();//new char[16];底层创建了一个长度是16的数组
    sb1.append('a');//value[0]='a';
    sb1.append('b');//value[1]='b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16];

    //问题1.System.out.println(ab2.length());//3
    //问题2.扩容问题：如果要添加的数据底层数组装不下，那就需要扩容底层的数组。
            默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。

            指导意义：开发中建议大家使用：StringBuffer(int capacity)或者StringBuilder(int capacity)
     */


    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }


    /*
    总结：
    增：append(xxx)
    删：delete(int start, int end)
    改：setChar(int n, char ch)/replace(int n, char ch, String str)
    查：charAt(int n)
    插：insert(int offset, xxx)
    长度：length()
    遍历：for()+charAt()/toString()
     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);

//        s1.delete(2,4);
//        s1.replace(2,4,"hello");
//        s1.insert(2,false);
//        s1.reverse();
        String s2 = s1.substring(1,3);

        System.out.println(s1);
        System.out.println(s1.length());

        System.out.println(s2);
    }
}
