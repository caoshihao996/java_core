package string_example;

import org.junit.Test;

public class StringMethodTest {

    @Test
    public void test(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1是不可变的
        System.out.println(s2);

        String s3 = "  hello world  ";
        String s4 = s3.trim();
        System.out.println("--"+s3+"--");
        System.out.println("--"+s4+"--");
    }

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//涉及到字符串排序


        String s7 = "西北工业大学";
        System.out.println(s7.substring(2,4));//左闭右开
    }

    @Test
    public void test2(){
        String s1 = "helloworld";
        System.out.println(s1.startsWith("he"));
        System.out.println(s1.endsWith("ld"));
        System.out.println(s1.startsWith("ell",1));


        String str2 = "wo";
        System.out.println(s1.contains(str2));

        System.out.println(s1.indexOf("lol"));
        System.out.println(s1.indexOf("lo",5));

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("r"));
        System.out.println(str3.lastIndexOf("or",6));
    }

    @Test
    public void test3(){
        String str1 = "西北工业大学";
        String str2 = str1.replace('北','东');

        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1.replace("西北","东北");
        System.out.println(str3);

        System.out.println("************");
        String str = "12hello34world5java7891mysql456";
        String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(string);

        str = "12345";
        boolean matches = str.matches("\\d+");
        System.out.println(matches);

        String tel1 = "0571-455123465";
        boolean result = tel1.matches("0571-\\d{7,8}");
        System.out.println(result);

        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

    }
}
