package collection;
class StringUtil{
    public static String initialCap(String string){
        if(string == null || "".equals(string)){
            return string;
        }
        else if(string.length()==1){
            return string.toUpperCase();
        }else {
            return string.substring(0,1).toUpperCase()+string.substring(1);
        }
    }
}
public class StringDemo {
    public static void main(String args[]){
        String str = "hello world!!!";
        String str1 = "m";
        System.out.println(StringUtil.initialCap(str));
        System.out.println(StringUtil.initialCap(str1));
    }
}
