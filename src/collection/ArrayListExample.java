package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

    public static void main(String[] args){

        ArrayList<String> a = new ArrayList<String>();

        a.add("asd");
        a.add("1234");
        a.add("example");

        /**for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }

        a.remove("asd");
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
        a.remove(0);
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }*/

        Iterator<String> e = a.iterator();
        while (e.hasNext()){
            String str = e.next();
            System.out.println(str);
        }
    }
}
